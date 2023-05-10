package model;

import java.util.ArrayList;

public interface AlmacenDatosDB {
    ArrayList<Empleado> getEmpleados();
     Empleado getEmpleado(String dni);
     int updateEmpleado(Empleado empleado);
     int removeEmpleado(String dni);
     Empleado addEmpleado(Empleado empleado);
     boolean authenticate(String login, String passwd);

}
