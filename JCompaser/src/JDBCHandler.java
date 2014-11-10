package jcompaser;
import java.sql.*;
import java.util.ArrayList;

public class JDBCHandler {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/JEngine";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "samsa";
    public static Connection connect() {
        Connection conn = null;
        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            } catch (SQLException se) {
                //Handle errors for JDBC
                System.out.println("hier");
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                System.out.println("da");

                e.printStackTrace();
            }
        return conn;
        }
}

