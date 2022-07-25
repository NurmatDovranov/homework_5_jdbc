package org.peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "postgres";

    public static Connection connection() {
        Connection connect = null;
        try{
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("Connected...");
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return connect;
    }
}