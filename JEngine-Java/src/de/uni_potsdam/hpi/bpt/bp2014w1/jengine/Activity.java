package de.uni_potsdam.hpi.bpt.bp2014w1.jengine;

import java.sql.*;
import java.util.LinkedList;

/**
 * Created by jaspar.mang on 04.11.14.
 */
public class Activity {
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
            System.out.println("hier");
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            System.out.println("da");

            e.printStackTrace();
        }
        return conn;
    }

    public LinkedList<Integer> getAllActivityIDByFragmentID(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        LinkedList<Integer> results = new LinkedList<Integer>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id FROM ProcessElement WHERE type = 'Activity' AND fragment_id = "+id+" ORDER BY id";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                results.add(rs.getInt("id"));
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
    public LinkedList<Integer> getAllActivityIDByFragmentID(String id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        LinkedList<Integer> results = new LinkedList<Integer>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id FROM ProcessElement WHERE type = 'Activity' AND fragment_id = "+id+" ORDER BY id";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                results.add(rs.getInt("id"));
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
    public LinkedList<String> getAllActivityNameByFragmentID(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        LinkedList<String> results = new LinkedList<String>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT label FROM ProcessElement, Activity WHERE ProcessElement.id=Activity.id AND type = 'Activity' AND fragment_id = "+id+" ORDER BY Activity.id";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                results.add(rs.getString("label"));
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
    public LinkedList<String> getAllActivityNameByFragmentID(String id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        LinkedList<String> results = new LinkedList<String>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT label FROM ProcessElement, Activity WHERE ProcessElement.id=Activity.id AND type = 'Activity' AND fragment_id = "+id+" ORDER BY Activity.id";

            rs = stmt.executeQuery(sql);
            while(rs.next()){
                results.add(rs.getString("label"));
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
    public String getActivityLabel(String id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        String results = "";
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT label FROM Activity WHERE id="+id;

            rs = stmt.executeQuery(sql);
            rs.next();
            results = rs.getString("label");


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
    public String getActivityLabel(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        String results = "";
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT label FROM Activity WHERE id="+id;

            rs = stmt.executeQuery(sql);
            rs.next();
            results = rs.getString("label");


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
