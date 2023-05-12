package model;

import model.dataSource.ConectorDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyOracleDataBase implements AlmacenDatosDB {
    @Override
    public ArrayList<Empleado> getEmpleados() {
        DataSource ds = ConectorDS.getMyOracleDataSource();
        ArrayList<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)
        ){
            Empleado empleado;
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
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
        return null;
    }

    @Override
    public int updateEmpleado(Empleado empleado) {
        return 0;
    }

    @Override
    public int removeEmpleado(String dni) {
        return 0;
    }

    @Override
    public boolean addEmpleado(Empleado empleado) {
        return false;
    }

    @Override
    public boolean authenticate(String login, String passwd) {
        return false;
    }

    @Override
    public ArrayList<Empleado> getEmpleadosPorCargo(String cargo) {
        return null;
    }
}
