package model.taserfan;


import model.dataSource.ConectorDS;
import oracle.jdbc.OracleTypes;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GestionCoche implements IGestionCoches {
    @Override
    public Coche getCar(String matricula) throws SQLException {
        DataSource dataSource = ConectorDS.getMyOracleDataSource();
        Coche coche = null;
        String query = "{ call GESTIONVEHICULOS.consultarcoche(?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.setString(1, matricula); //in
            callableStatement.registerOutParameter(1, OracleTypes.VARCHAR);//in out (ambas formas)
            callableStatement.registerOutParameter(2, OracleTypes.NUMBER); //out
            callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(4, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(5, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
            callableStatement.registerOutParameter(7, OracleTypes.DATE);
            callableStatement.registerOutParameter(8, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(9, OracleTypes.VARCHAR);
            callableStatement.registerOutParameter(10, OracleTypes.NUMBER);
            callableStatement.registerOutParameter(11, OracleTypes.NUMBER);
            //si hace executeQuery devuelve ResultSet pero no queremos eso.
            callableStatement.execute(); //devuelve un booleano
            coche = new Coche(callableStatement.getString(1), callableStatement.getDouble(2),
                    callableStatement.getString(3), callableStatement.getString(4),
                    callableStatement.getString(5), callableStatement.getInt(6), callableStatement.getDate(7),
                    callableStatement.getString(8), callableStatement.getString(9), callableStatement.getShort(10),
                    callableStatement.getShort(11));

        }
        return coche;
    }

    @Override
    public void removeCar(String matricula) throws SQLException {

    }

    @Override
    public List<Coche> getAllCars() throws SQLException {
        return null;
    }

    @Override
    public void addCar(Coche coche) throws SQLException {

    }

    @Override
    public void updateCar(Coche coche) throws SQLException {

    }
}
