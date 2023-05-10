import model.AlmacenDatosDB;
import model.Empleado;
import model.MySqlDataBase;

import java.sql.Date;
import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        AlmacenDatosDB db = new MySqlDataBase();
        List<Empleado> empleados = db.getEmpleados();
       // System.out.println(empleados);

        Empleado empleado = db.getEmpleado("3X");
        //System.out.println(empleado);

//        empleado.setApellidos("ruiz");
//        empleado.setNombre("helena");
        //System.out.println( db.updateEmpleado(empleado));
        //System.out.println(empleado);
        //System.out.println(db.removeEmpleado(empleado.getDni()));
       // System.out.println(db.addEmpleado(new Empleado(0,"123","123","","","","", Date.valueOf("2023-10-10"),"")));
        System.out.println(db.authenticate("empleado4@empresa.es","1111"));
    }
}
