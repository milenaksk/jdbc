package application;

import db.DB;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {
        Connection conn = DB.getConnection(); //chamando o método para se conectar ao banco
        DB.closeConnection();
    }
}
