import model.AlmacenDatosDB;
import model.Empleado;
import model.MyOracleDataBase;
import model.MySqlDataBase;

import java.sql.Date;
import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        /*MYSQL*/
        AlmacenDatosDB db = new MySqlDataBase();
        //List<Empleado> empleados = db.getEmpleados();
       // System.out.println(empleados);

        //Empleado empleado = db.getEmpleado("3X");
        //System.out.println(empleado);
//        empleado.setApellidos("ruiz");
//        empleado.setNombre("helena");
        //System.out.println( db.updateEmpleado(empleado));
        //System.out.println(empleado);
        //System.out.println(db.removeEmpleado(empleado.getDni()));
        System.out.println(db.addEmpleado(new Empleado(0,"354C","ppt6","teqer","la casa6","134","mme@ptet.es", Date.valueOf("2023-10-10"),"desemple","123")));
        //System.out.println(db.authenticate("empleado4@empresa.es","1111"));
//        System.out.println(db.getEmpleadosPorCargo("empleada"));
        //System.out.println(db.getEmpleado("4X"));
//        System.out.println(db.authenticate("empleado3@empresa.es","1111"));

        /*ORACLE*/
//        AlmacenDatosDB db = new MyOracleDataBase();
//        List<Empleado> empleados = db.getEmpleados();
//        System.out.println(empleados);
    }
}
