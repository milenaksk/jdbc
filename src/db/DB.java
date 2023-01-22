package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;


    public static Connection getConnection() { //abrindo conexao com banco de dados
        if(conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() { //fechando uma conexao com banco de dados
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    private static Properties loadProperties() { //lendo o arquivo db.properties
        try  (FileInputStream fs = new FileInputStream("db.properties")) {
        Properties props = new Properties();
        props.load(fs);
        return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

}
