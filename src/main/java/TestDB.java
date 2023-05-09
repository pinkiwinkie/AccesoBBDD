import model.AlmacenDatosDB;
import model.Empleado;
import model.MySqlDataBase;
import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        AlmacenDatosDB db = new MySqlDataBase();
        List<Empleado> empleados = db.getEmpleados();
        System.out.println(empleados);
    }
}
