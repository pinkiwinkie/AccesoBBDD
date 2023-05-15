package model.taserfan;

import java.sql.Date;

public class Vehiculo {

    private final String matricula;
    private final double precioHora;
    private final String marca;
    private final String descripcion;
    private final String color;
    private final int bateria;
    private final Date fechaAdq;
    private final String estado;
    private final String idCarnet;

    public Vehiculo(String matricula, double precioHora, String marca, String descripcion, String color, int bateria, Date fechaAdq, String estado, String idCarnet) {
        this.matricula = matricula;
        this.precioHora = precioHora;
        this.marca = marca;
        this.descripcion = descripcion;
        this.color = color;
        this.bateria = bateria;
        this.fechaAdq = fechaAdq;
        this.estado = estado;
        this.idCarnet = idCarnet;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getColor() {
        return color;
    }

    public int getBateria() {
        return bateria;
    }

    public Date getFechaAdq() {
        return fechaAdq;
    }

    public String getEstado() {
        return estado;
    }

    public String getIdCarnet() {
        return idCarnet;
    }

    @Override
    public String toString() {
        return
                "matricula='" + matricula + '\'' +
                ", precioHora=" + precioHora +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", color='" + color + '\'' +
                ", bateria=" + bateria +
                ", fechaAdq=" + fechaAdq +
                ", estado='" + estado + '\'' +
                ", idCarnet=" + idCarnet;

    }
}
