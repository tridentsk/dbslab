package sample.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.controller.CustomController;
import sample.util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrewDAO {

    public static ResultSet searchCrew (String input, String param) throws SQLException {

        String basic = "SELECT * FROM Crew where %s=%s";
        String selectStmt = formatCrewString(input, basic, param);
        try {
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
            return rsEmp;
        } catch (SQLException e) {
            System.out.println("While searching an Crew with " + param + " id, an error occurred: " + e);

            throw e;
        }
    }

    public static void deleteCrew (String ID) throws SQLException{
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM Crew\n" +
                        "         WHERE ID ="+ ID +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("Employee with ID="+ ID + " deleted.");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static void insertCrew (String ... details) throws SQLException, ClassNotFoundException {
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO Crew\n" +
                        "VALUES\n" +
                        "("+details[0]+", '"+details[1]+"',"+details[2]+","+ details[3]+ ",\'"+details[4]+"\',\'"
                            +details[5]+"\',\'"+details[6]+"\','"+details[7]+"');\n" +
                        "END;";
        System.out.println(updateStmt);
        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            DBUtil.dbExecuteUpdate("commit");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static void updateCrew (String ... details) throws SQLException, ClassNotFoundException{
        //Declare a UPDATE statement
        /*deleteCrew(details[0]);
        insertCrew(details);*/

        String update = "BEGIN " +
                " UPDATE CREW " +
                " SET " + "crew_name='" + details[1] +"',"
                    + "age=" + details[2] + "," +
                    "yrs_of_exp=" +details[3] + "," +
                    "ship_name='" + details[4] + "'," +
                    "faction_name='" + details[5] + "'," +
                    "post_name='" + details[6] + "'," +
                    "sex='" + details[7] + "' " +
                " WHERE ID=" + details[0] + "; END;";
                System.out.println(update);
        try {
            DBUtil.dbExecuteUpdate(update);
            DBUtil.dbExecuteUpdate("commit");
        } catch (SQLException e) {
            System.out.print("Error occurred while updating " + e);
            throw e;
        }
    }

    public static String formatCrewString(String input, String basic, String param){
        String selectStmt = "";
        switch(param){
            case "ID":
            case "yrs_of_exp":
            case "age":
                selectStmt = String.format(basic, param, Integer.parseInt(input));
                break;
            case "ship_name":
            case "faction_name":
            case "post_name":
            case "crew_name":
            case "sex":
                selectStmt = String.format(basic, param, "\'"+ input + "\'");
                break;
        }
        return selectStmt;
    }




}