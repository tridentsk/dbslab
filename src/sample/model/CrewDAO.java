package sample.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrewDAO {

    //*******************************
    //SELECT a Crew member
    //*******************************
    public static ObservableList<Crew> searchCrew (String input, String param) throws SQLException {
        //Declare a SELECT statement
        String basic = "SELECT * FROM Crew where %s=%s";
        String selectStmt = formatCrewString(input, basic, param);
        /*String selectStmt = "SELECT * FROM Crew WHERE ID="+crewID;*/

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getCrewFromResultSet method and get Crew object
            ObservableList<Crew> crewList = getCrewList(rsEmp);
            /*Crew crew = getCrewFromResultSet(rsEmp);
            //Return Crew object*/
            return crewList;
        } catch (SQLException e) {
            System.out.println("While searching an Crew with " + param + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //*************************************
    //DELETE an employee
    //*************************************
    public static void deleteCrew (String ID) throws SQLException{
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM Crew\n" +
                        "         WHERE ID ="+ ID +";\n" +
                        "   COMMIT;\n" +
                        "END;";
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("Employee with ID="+ ID + " deleted.");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static void insertCrew (String ... details) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        //"(ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)\n" +
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO Crew\n" +
                        "VALUES\n" +
                        "("+details[0]+", '"+details[1]+"',"+details[2]+","+ details[3]+ ","+details[4]+","
                            +details[5]+","+details[6]+",'"+details[7]+"');\n" +
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
        deleteCrew(details[0]);
        insertCrew(details);

        //Execute UPDATE operation
        /*try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }*/
    }
    //Use ResultSet from DB as parameter and set Crew Object's attributes and return Crew object.
    public static ObservableList<Crew> getCrewList(ResultSet rs) throws SQLException
    {
        ObservableList<Crew> crewList = FXCollections.observableArrayList();

        while (rs.next()) {
            Crew crw = new Crew();
            crw.setID(rs.getInt("ID"));
            //System.out.println(rs.getInt("ID"));
            crw.setcrew_name(rs.getString("crew_name"));
            crw.setage(rs.getInt("AGE"));
            crw.setyrs_of_exp(rs.getInt("YRS_OF_EXP"));
            crw.setsex(rs.getString("SEX"));
            crw.setship_id(rs.getInt("ship_id"));
            crw.setfaction_id(rs.getInt("faction_id"));
            crw.setpost_id(rs.getInt("post_id"));
            crewList.add(crw);
        }
        return crewList;
    }

    public static String formatCrewString(String input, String basic, String param){
        String selectStmt = "";
        switch(param){
            case "ID":
            case "yrs_of_exp":
            case "ship_id":
            case "age":
            case "faction_id":
            case "post_id":
                selectStmt = String.format(basic, param, Integer.parseInt(input));
                break;
            case "crew_name":
            case "sex":
                selectStmt = String.format(basic, param, "\'"+ input + "\'");
                break;
        }
        return selectStmt;
    }




}