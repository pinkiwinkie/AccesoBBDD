import model.dataSource.ConectorDS;
import model.dataManagerDeprecated.ConectorMD;
import javax.sql.DataSource;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ConectorMD conectorMD = new ConectorMD();
        conectorMD.conectarMySQL();
        conectorMD.conectarOracle();

        Connection connection;
        try{
//            DataSource dataSource = Conector.getMySQLDataSource();
        DataSource dataSource = ConectorDS.getMyOracleDataSource();
            connection = dataSource.getConnection();
            if (connection != null)
                System.out.println("acceso exitoso");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
