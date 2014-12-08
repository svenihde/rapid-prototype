package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by jaspar.mang on 05.11.14.
 */
public class Reference {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/JEngine";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "samsa";

    private Connection connect() {
        Connection conn = null;
        try {
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException se) {
            //Handle errors for JDBC

            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName

            e.printStackTrace();
        }
        return conn;
    }

    public LinkedList<Integer> getReference(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        LinkedList<Integer> results = new LinkedList<Integer>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT processElement_id2 FROM Reference WHERE processElement_id1=" + id;

            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (!results.contains(rs.getInt("processElement_id2"))) {
                    results.add(rs.getInt("processElement_id2"));
                }
            }

            stmt = conn.createStatement();
            sql = "SELECT processElement_id1 FROM Reference WHERE processElement_id2=" + id;

            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                if (!results.contains(rs.getInt("processElement_id1"))){
                    results.add(rs.getInt("processElement_id1"));
                }
            }

            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return results;
    }
}