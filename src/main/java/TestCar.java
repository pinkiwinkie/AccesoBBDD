import model.taserfan.Coche;
import model.taserfan.GestionCoche;

import java.sql.SQLException;

public class TestCar {
    public static void main(String[] args) {
        GestionCoche gestionCoche = new GestionCoche();
        try {
            Coche coche = gestionCoche.getCar("1111AAA");
            System.out.println(coche);
        } catch (SQLException e){
            e.printStackTrace();
        }

}
