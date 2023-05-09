import model.AlmacenDatosDB;
import model.Empleado;
import model.MySqlDataBase;
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
        System.out.println(db.addEmpleado());

    }
}
