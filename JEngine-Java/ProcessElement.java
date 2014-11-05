import java.sql.*;
import java.util.ArrayList;

/**
 * Created by jaspar.mang on 04.11.14.
 */
public class ProcessElement {
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

    public String getProcessElementType(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        String results = "";
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT type FROM ProcessElement WHERE id="+id;

            rs = stmt.executeQuery(sql);
            rs.next();
            results = rs.getString("type");


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
    public String getProcessElementType(String id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        String results = "";
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT type FROM ProcessElement WHERE id="+id;

            rs = stmt.executeQuery(sql);
            rs.next();
            results = rs.getString("type");


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

    public ArrayList<Integer> getAllProcessElementIDByFragmentID(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id FROM ProcessElement WHERE fragment_id = "+id+" ORDER BY id";

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
    public ArrayList<Integer> getAllProcessElementIDByFragmentID(String id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id FROM ProcessElement WHERE fragment_id = "+id+" ORDER BY id";

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

    public int getFragmentID(int id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        int results = -1;
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT fragment_id FROM ProcessElement WHERE id="+id;

            rs = stmt.executeQuery(sql);
            rs.next();
            results = rs.getInt("fragment_id");


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
    public int getFragmentID(String id) {
        Connection conn = this.connect();

        Statement stmt = null;
        ResultSet rs = null;
        int results = -1;
        if (conn == null) return results;

        try {
            //Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT fragment_id FROM ProcessElement WHERE id="+id;

            rs = stmt.executeQuery(sql);
            rs.next();
            results = rs.getInt("fragment_id");


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
