package RegistrationForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String url="jdbc:mysql://localhost:3306/REGISTRATION";
    private final static String userName="root";
    private final static String password="12345";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }
}
