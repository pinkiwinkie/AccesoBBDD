package model.taserfan;

import java.sql.Blob;
import java.sql.Date;

public class Cliente {
    private int idCliente;
    private final String DNI;
    private final String nombre;
    private final String apellidos;
    private final String domicilio;
    private final String CP;
    private final String Email;
    private final Date fechaNac;
    private final short idCarnet;
    private Blob foto;

    public Cliente(String DNI, String nombre, String apellidos, String domicilio, String CP, String email, Date fechaNac, short idCarnet) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.CP = CP;
        Email = email;
        this.fechaNac = fechaNac;
        this.idCarnet = idCarnet;
    }
    public Cliente(String DNI, String nombre, String apellidos, String domicilio, String CP, String email, Date fechaNac, short idCarnet, Blob foto) {
        this(DNI, nombre, apellidos, domicilio, CP, email, fechaNac, idCarnet);
        this.foto = foto;
    }
    public Cliente(int idCliente, String DNI, String nombre, String apellidos, String domicilio, String CP, String email, Date fechaNac, short idCarnet, Blob foto) {
        this(DNI, nombre, apellidos, domicilio, CP, email, fechaNac, idCarnet, foto);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getCP() {
        return CP;
    }

    public String getEmail() {
        return Email;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public short getIdCarnet() {
        return idCarnet;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", CP='" + CP + '\'' +
                ", Email='" + Email + '\'' +
                ", fechaNac=" + fechaNac +
                ", idCarnet=" + idCarnet +
                " \n";
    }
}

