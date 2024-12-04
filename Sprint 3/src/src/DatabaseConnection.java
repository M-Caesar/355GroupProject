package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/HospitalManagement?useSSL=false&serverTimezone=America/New_York";
    private static final String USER = "root";
    private static final String PASSWORD = "SQL355%Grouppa55"; // Replace with your root password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
