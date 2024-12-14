package student.management.system;

import java.sql.*;

public class DBHelper {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentmanagementsystem"; // Your DB URL
    private static final String USER = "root"; // Your DB username
    private static final String PASS = "2100401"; // Your DB password

    // Create a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
