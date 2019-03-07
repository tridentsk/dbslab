package sample.util;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {
    //Declare JDBC Driver
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    //Connection
    private static Connection conn = null;

    //Connect to DB
    public static void dbConnect() throws SQLException {
        //Setting Oracle JDBC Driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Oracle JDBC Driver Registered");
        //Establish the Oracle Connection using Connection String
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "p0laris");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
        }
    }

    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    public static ResultSet dbExecuteQuery(String qry) throws SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            //Connect to DB
            dbConnect();
            System.out.println("Select statement: " + qry + "\n");
            //Create statement
            stmt = conn.createStatement();
            //Execute select (query) operation
            resultSet = stmt.executeQuery(qry);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return ResultSet
        return crs;
    }

    public static void dbExecuteUpdate(String upd) throws SQLException{
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(upd);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }
}
