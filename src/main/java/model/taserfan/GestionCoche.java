package model.taserfan;


import model.dataSource.ConectorDS;
import oracle.jdbc.OracleTypes;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestionCoche implements IGestionCoches {
    public static final String COCHES = "COCHE";
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
        DataSource dataSource = ConectorDS.getMyOracleDataSource();
        String query = "{ call GESTIONVEHICULOS.borrarCoche(?) }";
        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.setString(1,matricula);
            callableStatement.execute();
        }
    }

    @Override
    public List<Coche> getAllCars() throws SQLException {
        DataSource ds = ConectorDS.getMyOracleDataSource();
        List<Coche> coches = new ArrayList<>();

        String query = " { call GESTIONVEHICULOS.listarvehiculos(?,?)}";

        try (Connection con = ds.getConnection();
             CallableStatement cs = con.prepareCall(query)) {

            cs.setString(1,COCHES);
            cs.registerOutParameter(2, OracleTypes.CURSOR);

            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(2);
            while (rs.next()) {
                Coche coche = new Coche(rs.getString(13),
                        rs.getDouble(3),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getInt(4),
                        formatearFecha(rs.getString(17)),
                        rs.getString(18),
                        rs.getString(19),
                        rs.getShort(5),
                        rs.getShort(6));
                coches.add(coche);
            }
        }
        return coches;
    }

    @Override
    public void addCar(Coche coche) throws SQLException {
        DataSource dataSource = ConectorDS.getMyOracleDataSource();
        String query = "{ call GESTIONVEHICULOS.insertarCoche(?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.setString(1, coche.getMatricula());
            callableStatement.setDouble(2, coche.getPrecioHora());
            callableStatement.setString(3, coche.getMarca());
            callableStatement.setString(4, coche.getDescripcion());
            callableStatement.setString(5, coche.getColor());
            callableStatement.setInt(6, coche.getBateria());
            callableStatement.setDate(7, coche.getFechaAdq());
            callableStatement.setString(8, coche.getEstado());
            callableStatement.setString(9, coche.getIdCarnet());
            callableStatement.setShort(10, coche.getNumPlazas());
            callableStatement.setShort(11, coche.getNumPuertas());
            callableStatement.execute();
        }
    }

    @Override
    public void updateCar(Coche coche) throws SQLException {
        DataSource dataSource = ConectorDS.getMyOracleDataSource();
        String query = "{ call GESTIONVEHICULOS.actualizarcoche(?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)
        ) {
            callableStatement.setString(1, coche.getMatricula());
            callableStatement.setDouble(2, coche.getPrecioHora());
            callableStatement.setString(3, coche.getMarca());
            callableStatement.setString(4, coche.getDescripcion());
            callableStatement.setString(5, coche.getColor());
            callableStatement.setInt(6, coche.getBateria());
            callableStatement.setDate(7, coche.getFechaAdq());
            callableStatement.setString(8, coche.getEstado());
            callableStatement.setString(9, coche.getIdCarnet());
            callableStatement.setShort(10, coche.getNumPlazas());
            callableStatement.setShort(11, coche.getNumPuertas());
            callableStatement.execute();
        }
    }
    private Date formatearFecha(String fechaEntrada){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate fecha = LocalDate.parse(fechaEntrada, formatter);
        return Date.valueOf(fecha);
    }
}
