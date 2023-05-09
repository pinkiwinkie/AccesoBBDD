package model;

import java.sql.Date;

public class Empleado {
    private int idEmpleado;
    private String dni,
            nombre,
            apellidos,
            domicilio,
            cp,
            email,
            password,
            cargo;
    private Date fechaNac;


    public Empleado(int idEmpleado, String dni, String nombre, String apellidos, String domicilio, String cp, String email, Date fechaNac,String cargo) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.cp = cp;
        this.email = email;
        this.cargo = cargo;
        this.fechaNac = fechaNac;
    }

    public Empleado(int idEmpleado, String dni, String nombre, String apellidos, String domicilio, String cp, String email, Date fechaNac, String cargo, String password) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.cp = cp;
        this.email = email;
        this.password = password;
        this.cargo = cargo;
        this.fechaNac = fechaNac;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCp() {
        return cp;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    public String getPassword() {
        return password;
    }

    public Date getFechaNac() {
        return fechaNac;
    }
    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cp='" + cp + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                ", password='" + password + '\'' +
                ", fechaNac=" + fechaNac +
                '}';
    }
}
