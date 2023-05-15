package model.taserfan;

import java.sql.SQLException;
import java.util.List;

public interface IGestionCoches {
    Coche getCar(String matricula) throws SQLException;
    void removeCar(String matricula) throws SQLException;
    List<Coche> getAllCars() throws SQLException;
    void addCar(Coche coche) throws SQLException;
    void updateCar(Coche coche) throws SQLException;
}
