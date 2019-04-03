package sample.util;

import com.sun.rowset.CachedRowSetImpl;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.Optional;


public class DBUtil {
    //Declare JDBC Driver
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    //Connection
    private static Connection conn = null;

    //Connect to DB
    public static void dbConnect() {
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
            System.out.println("Statement: " + qry + "\n");
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

    public static void throwError(String brief){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(brief);
        alert.setContentText("One or more details entered is invalid. The chosen faction, ship or post does not exist");
        alert.showAndWait();
    }

    public static Optional<ButtonType> reqConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setContentText("Are you sure you want to remove this employee from the database?");
         return alert.showAndWait();
    }

    public static void notPerformed(String brief){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(brief);
        alert.setContentText("Action cancelled by user. The employee was not removed. ");
        alert.showAndWait();
    }

}
