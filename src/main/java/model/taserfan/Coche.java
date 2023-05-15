package model.taserfan;

import java.sql.Date;

public class Coche extends Vehiculo {

    private short numPlazas;
    private short numPuertas;

    public Coche(String matricula, double precioHora, String marca, String descripcion, String color, int bateria, Date fechaAdq, String estado, String idCarnet, short numPlazas, short numPuertas) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, idCarnet);
        this.numPlazas = numPlazas;
        this.numPuertas = numPuertas;
    }

    public short getNumPlazas() {
        return numPlazas;
    }

    public short getNumPuertas() {
        return numPuertas;
    }

    public void setNumPlazas(short numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void setNumPuertas(short numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        return "Coche{" + super.toString() +
                ", numPlazas=" + numPlazas +
                ", numPuertas=" + numPuertas +
                "} \n";
    }
}
