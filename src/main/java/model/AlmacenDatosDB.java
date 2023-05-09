package model;

import java.util.ArrayList;

public interface AlmacenDatosDB {
    ArrayList<Empleado> getEmpleados();
     Empleado getEmpleado(String dni);
     int updateEmpleado(Empleado empleado);
     int removeEmpleado(String dni);
     boolean addEmpleado();
}
