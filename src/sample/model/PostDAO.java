package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDAO {

    //*******************************
    //SELECT a Post
    //*******************************
    public static ObservableList<Post> searchPost (String input, String param) throws SQLException {
        //Declare a SELECT statement
        String basic = "SELECT * FROM Post where %s=%s";
        String selectStmt = formatPostString(input, basic, param);
        /*String selectStmt = "SELECT * FROM Post WHERE ID="+PostID;*/

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getPostFromResultSet method and get Post object
            ObservableList<Post> postList = getPostList(rsEmp);
            /*Post crew = getPostFromResultSet(rsEmp);
            //Return Post object*/
            return postList;
        } catch (SQLException e) {
            System.out.println("While searching an Post with " + param + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    private static ObservableList<Post> getPostList(ResultSet rs) throws SQLException
    {
        ObservableList<Post> postList = FXCollections.observableArrayList();

        while (rs.next()) {
            Post pst = new Post();
            pst.setP_id(rs.getInt("post_id"));
            pst.setP_name(rs.getString("P_NAME"));
            pst.setsalary(rs.getInt("SALARY"));
            pst.setyrs_of_exp_req(rs.getInt("YRS_OF_EXP_REQ"));
            postList.add(pst);
        }
        return postList;
    }

    public static String formatPostString(String input, String basic, String param){
        String selectStmt = "";
        switch(param){
            case "post_id":
            case "yrs_of_exp_req":
            case "salary":
                selectStmt = String.format(basic, param, Integer.parseInt(input));
                break;
            case "P_name":
                selectStmt = String.format(basic, param, "\'"+ input + "\'");
                break;
        }
        return selectStmt;
    }

    public static void insertPost (String ... details) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO Post\n" +
                        "VALUES\n" +
                        "("+details[0]+", '"+details[1]+"',"+details[2]+","+ details[3]+");\n" +
                        "END;";
        System.out.println(updateStmt);
        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            DBUtil.dbExecuteUpdate("commit");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE: " + e);
            throw e;
        }
    }
    //*************************************
    //DELETE a post
    //*************************************
    public static void deletePost (String post_id) throws SQLException{
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM Post\n" +
                        "         WHERE post_id ="+ post_id +";\n" +
                        "   COMMIT;\n" +
                        "END;";
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
            System.out.println("Post with ID="+ post_id + " deleted.");
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static void updatePost (String ... details) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        deletePost(details[0]);
        insertPost(details);
    }
}
