import model.taserfan.Coche;
import model.taserfan.GestionCoche;

import java.sql.Date;
import java.sql.SQLException;

public class TestCar {
    public static void main(String[] args) {
        Coche coche = new Coche("7428KCD",15.0,"Seat","Ibiza", "blanco",26,Date.valueOf("2017-05-05"),
                "nuevo","3", (short) 5, (short) 5);
        GestionCoche gestionCoche = new GestionCoche();
        try {
            //gestionCoche.addCar(coche);
            gestionCoche.removeCar("7428KCD");
//            Coche coche = gestionCoche.getCar("1111AAA");
//            System.out.println(coche);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
