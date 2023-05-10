package model;

import model.dataSource.ConectorDS;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class MySqlDataBase implements AlmacenDatosDB {
    @Override
    public ArrayList<Empleado> getEmpleados() {
        //crear conexion
        DataSource ds = ConectorDS.getMySQLDataSource();
        ArrayList<Empleado> empleados = new ArrayList<>();
        //se crea el statement
        try (Connection connection = ds.getConnection();
             //el statement execute the query
             Statement statement = connection.createStatement();
             //conjunto de resultados
             ResultSet resultSet = statement.executeQuery("SELECT * FROM empleado")
        ) {
            Empleado empleado;
            while (resultSet.next()) {
                empleado = new Empleado(resultSet.getInt("id"), resultSet.getString("DNI"),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString("email"), resultSet.getDate(8), resultSet.getString(9));
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }

    @Override
    public Empleado getEmpleado(String dni) {
        Empleado empleado = null;
        DataSource ds = ConectorDS.getMySQLDataSource();
        String query = "SELECT * FROM empleado where dni = ?;";
        try (Connection connection = ds.getConnection();
             //el statement execute the query
             PreparedStatement preparedStatement = connection.prepareStatement(query)
             //conjunto de resultados
        ) {
            preparedStatement.setString(1,dni);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                empleado = new Empleado(resultSet.getInt("id"), resultSet.getString("DNI"),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString("email"), resultSet.getDate(8), resultSet.getString(9));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleado;
    }

    @Override
    public int updateEmpleado(Empleado empleado) {
        int actualizado = 0;
        DataSource ds = ConectorDS.getMySQLDataSource();
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = "UPDATE empleado SET nombre=\"" + empleado.getNombre() + "\", "
                    + "apellidos=\"" + empleado.getApellidos() + "\"," + "domicilio=\"" +
                    empleado.getDomicilio() + "\"," + "CP=\"" + empleado.getCp() + "\"," +
                    "email=\"" + empleado.getEmail() + "\"," + "fechaNac=\"" +
                    empleado.getFechaNac() + "\"," + "cargo=\"" + empleado.getCargo() + "\" " +
                    "WHERE DNI=\"" + empleado.getDni() + "\"";
            actualizado = statement.executeUpdate(query); //devuelve un entero
//            if (i > 0)
//                actualizado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return actualizado;
    }

    @Override
    public int removeEmpleado(String dni) {
        int deleted = 0;
        DataSource ds = ConectorDS.getMySQLDataSource();
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = "delete from empleado WHERE DNI='" + dni + "';";
            deleted = statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    @Override
    public Empleado addEmpleado(Empleado empleado) {
        DataSource ds = ConectorDS.getMySQLDataSource();
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = "insert into empleado (nombre, dni) values ('" +empleado.getNombre() +"','"+empleado.getDni()+"');";
            statement.executeUpdate(query);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleado;
    }
//CAMBIARLO AL PREPAREDSTATEMENT -> evita SqlInjection
    @Override
    public boolean authenticate(String login, String passwd) {
        boolean auth = false;
        //case sensitive
        String query = "select count(*) from empleado " +
                "where email = ? and password= ?;";
        DataSource ds = ConectorDS.getMySQLDataSource();
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)
        ) {
           rs.next();
           int count = rs.getInt(1);
           auth = count != 0;


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auth;
    }

    @Override
    public ArrayList<Empleado> getEmpleadosPorCargo(String cargo) {
        DataSource ds = ConectorDS.getMySQLDataSource();
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        String query = "select * from empleado where cargo = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {//el 1 es la posicion del ?, si hubiere mas, irian en orden.
            preparedStatement.setString(1,cargo);
            ResultSet resultSet = preparedStatement.executeQuery();
            Empleado empleado;
            while (resultSet.next()) {
                empleado = new Empleado(resultSet.getInt("id"), resultSet.getString("DNI"),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString("email"), resultSet.getDate(8), resultSet.getString(9));
                empleados.add(empleado);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }
}
