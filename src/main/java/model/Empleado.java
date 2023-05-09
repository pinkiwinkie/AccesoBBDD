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

    public String getDni() {
        return dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", cp='" + cp + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cargo='" + cargo + '\'' +
                ", fechaNac=" + fechaNac +
                '}';
    }
}
