package model;

import model.dataSource.ConectorDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            while (resultSet.next()){
                empleado = new Empleado(resultSet.getInt("id"),resultSet.getString("DNI"),
                        resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString("email"),resultSet.getDate(8),resultSet.getString(9));
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }
}
