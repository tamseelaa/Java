package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/currency_db";
    private static final String USER = "roots";       // your DB user
    private static final String PASSWORD = "Shahid75"; // your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}