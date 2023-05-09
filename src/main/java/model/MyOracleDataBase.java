package model;

import model.dataSource.ConectorDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

//public class MyOracleDataBase implements AlmacenDatosDB {
//    @Override
//    public ArrayList<Empleado> getEmpleados() {
//        DataSource ds = ConectorDS.getMyOracleDataSource();
//        ArrayList<Empleado> empleados = new ArrayList<>();
//        try (Connection con = ds.getConnection();
//             Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLEADO");) {
//            Empleado empleado;
//            while (rs.next()) {
//                empleado = new Empleado(rs.getInt("idEmpleado"), rs.getString("DNI"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("domicilio"), rs.getString("CP"), rs.getString("email"), rs.getDate("fechaNac"), rs.getString("cargo"));
//                empleados.add(empleado);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return empleados;
//    }
//}
