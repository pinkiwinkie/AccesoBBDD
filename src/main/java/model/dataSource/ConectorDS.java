package model.dataSource;

import com.mysql.cj.jdbc.MysqlDataSource;
import oracle.jdbc.pool.OracleDataSource;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class
    public static DataSource getMySQLDataSource() {
        Properties properties = new Properties();
        MysqlDataSource mysqlDataSource = null;
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            properties.load(fis);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(properties.getProperty("MYSQL_DB_URL"));
            mysqlDataSource.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
            mysqlDataSource.setPassword(properties.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDataSource;
    }

    public static DataSource getMyOracleDataSource(){
        Properties properties = new Properties();
        OracleDataSource oracleDataSource = null;
        try (FileInputStream fis = new FileInputStream("db.properties")) {
            properties.load(fis);
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(properties.getProperty("ORACLE_DB_URL"));
            oracleDataSource.setUser(properties.getProperty("ORACLE_DB_USERNAME"));
            oracleDataSource.setPassword(properties.getProperty("ORACLE_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return oracleDataSource;
    }
}
