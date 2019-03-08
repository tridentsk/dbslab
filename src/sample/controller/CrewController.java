package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.model.Crew;
import sample.model.CrewDAO;
import sample.model.Post;
import sample.model.PostDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CrewController {
    @FXML
    private TextField searchCrewByText;
    @FXML
    private TextField crewIDText;
    @FXML
    private TextField crewNameText;
    @FXML
    private TextField crewAgeText;
    @FXML
    private TextField crewSexText;
    @FXML
    private TextField crewYrsText;
    @FXML
    private TextField crewSIDText;
    @FXML
    private TextField crewPIDText;
    @FXML
    private TextField crewFIDText;
    @FXML
    private TableColumn<Crew, Integer> crewIDColumn;
    @FXML
    private TableColumn<Crew, String> crewNameColumn;
    @FXML
    private TableColumn<Crew, Integer> crewAgeColumn;
    @FXML
    private TableColumn<Crew, Integer> crewYearsColumn;
    @FXML
    private TableColumn<Crew, Integer> crewSIDColumn;
    @FXML
    private TableColumn<Crew, Integer> crewFIDColumn;
    @FXML
    private TableColumn<Crew, Integer> crewPIDColumn;
    @FXML
    private ComboBox<String> searchparam;
    @FXML
    private TableColumn<Crew, String> crewSexColumn;
    @FXML
    private TableView<Crew> crewTable;
    @FXML
    private AnchorPane crewTab;
    @FXML
    private TextField postSearchText;
    @FXML
    private TextField postIDText;
    @FXML
    private TextField postNameText;
    @FXML
    private TextField postsalaryText;
    @FXML
    private TextField postyrs_of_exp_reqText;
    @FXML
    private TableColumn<Post, Integer> postIDColumn;
    @FXML
    private TableColumn<Post, String> postNameColumn;
    @FXML
    private TableColumn<Post, Integer> postSalaryColumn;
    @FXML
    private TableColumn<Post, Integer> postYearsColumn;
    @FXML
    private ComboBox<String> postSearch;
    @FXML
    private TableView<Post> postTable;
    @FXML
    private AnchorPane postTab;

    @FXML
    private void searchPost (ActionEvent actionEvent) throws SQLException {
        try {
            String paramval = postSearch.getValue();
            String param = parsePostParam(paramval);
            ObservableList<Post> pst = PostDAO.searchPost(postSearchText.getText(), param);
            //Populate Post on TableView and Display on TextArea
            populatePost(pst);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    private void deletePost (ActionEvent actionEvent) throws SQLException {
        try {
            PostDAO.deletePost(postIDText.getText());
            postTable.getItems().clear();
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void insertPost (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            PostDAO.insertPost(getAllPostDetails());

            ObservableList<Post> pst = PostDAO.searchPost(postIDText.getText(), "P_id");
            populatePost(pst);
            clearPostTexts();
        } catch (SQLException e) {

            throw e;
        }
    }
    @FXML
    private void updatePost(ActionEvent actionEvent) throws ClassNotFoundException{
        try {
            PostDAO.updatePost(getAllPostDetails());
            ObservableList<Post> pst = PostDAO.searchPost(getAllPostDetails()[0], "P_id");
            clearPostTexts();
            populatePost(pst);
        } catch (SQLException e) {

        }
    }

    private String[] getAllPostDetails(){
        String ar[] = new String[] {
                postIDText.getText(),
                postNameText.getText(),
                postsalaryText.getText(),
                postyrs_of_exp_reqText.getText()
        };
        return ar;
    }

    @FXML
    private void clearPostTexts(){
        for (Node node : postTab.getChildren()){
            if(node instanceof TextField){
                ((TextField) node).setText("");
            }
        }
    }

    private void populatePost (ObservableList<Post> pst){
        postTable.setItems(pst);
    }

    @FXML
    private void initialize() {
        crewIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        crewNameColumn.setCellValueFactory(cellData -> cellData.getValue().E_NameProperty());
        crewAgeColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        crewYearsColumn.setCellValueFactory(cellData -> cellData.getValue().yrs_of_expProperty().asObject());
        crewSexColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        crewSIDColumn.setCellValueFactory(cellData -> cellData.getValue().S_idProperty().asObject());
        crewFIDColumn.setCellValueFactory(cellData -> cellData.getValue().F_idProperty().asObject());
        crewPIDColumn.setCellValueFactory(cellData -> cellData.getValue().P_idProperty().asObject());

        ObservableList<String> paramlist = FXCollections.observableArrayList(
                "ID",
                "Name",
                "Years of Exp",
                "Age",
                "Sex",
                "Ship ID",
                "Faction ID",
                "Port ID"
        );
        searchparam.setItems(paramlist);
        searchparam.setValue("ID");
        postIDColumn.setCellValueFactory(cellData -> cellData.getValue().P_idProperty().asObject());
        postNameColumn.setCellValueFactory(cellData -> cellData.getValue().P_nameProperty());
        postSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty().asObject());
        postYearsColumn.setCellValueFactory(cellData -> cellData.getValue().yrs_of_exp_reqProperty().asObject());
        paramlist = FXCollections.observableArrayList(
                "Post ID",
                "Name",
                "Salary",
                "Years of Exp"
        );

        postSearch.setItems(paramlist);
        postSearch.setValue("Post ID");
    }

    private String parsePostParam(String param){
        switch(param){
            case "Post ID":
                return "P_id";
            case "Name":
                return "P_name";
            case "Salary":
                return "salary";
            case "Years of Exp":
                return "yrs_of_exp_req";
        }
        return "";
    }

    @FXML
    private void searchCrew (ActionEvent actionEvent) throws SQLException {
        try {
                String paramval = searchparam.getValue();
                String param = parseParam(paramval);
                ObservableList<Crew> crw = CrewDAO.searchCrew(searchCrewByText.getText(), param);
            //Populate Crew on TableView and Display on TextArea
            populateCrew(crw);

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void deleteCrew (ActionEvent actionEvent) throws SQLException {
        try {
            CrewDAO.deleteCrew(crewIDText.getText());
            crewTable.getItems().clear();
        } catch (SQLException e) {
            throw e;
        }
    }

    @FXML
    private void insertCrew (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            CrewDAO.insertCrew(getAllDetails());

            ObservableList<Crew> crw = CrewDAO.searchCrew(crewIDText.getText(), "ID");
            populateCrew(crw);
            clearTexts();
        } catch (SQLException e) {

            throw e;
        }
    }

    @FXML
    private void updateCrew(ActionEvent actionEvent) throws ClassNotFoundException{
        try {
            CrewDAO.updateCrew(getAllDetails());
            ObservableList<Crew> crw = CrewDAO.searchCrew(getAllDetails()[0], "ID");
            clearTexts();
            populateCrew(crw);
        } catch (SQLException e) {

        }
    }
    private String[] getAllDetails(){
        String ar[] = new String[] {
                crewIDText.getText(),
                crewNameText.getText(),
                crewAgeText.getText(),
                crewYrsText.getText(),
                crewSIDText.getText(),
                crewFIDText.getText(),
                crewPIDText.getText(),
                crewSexText.getText()};
        return ar;
    }
    @FXML
    private void clearTexts(){
        for (Node node : crewTab.getChildren()){
            if(node instanceof TextField){
                ((TextField) node).setText("");
            }
        }
    }
    private void populateCrew (ObservableList<Crew> emp){
        crewTable.setItems(emp);
    }
/*
    private void populateAndShowCrew(Crew crw){
        if (crw != null) {
            populateCrew(crw);
        }
    }*/

   /* @FXML
    private void initialize () {
        crewIDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        crewNameColumn.setCellValueFactory(cellData -> cellData.getValue().E_NameProperty());
        crewAgeColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
        crewYearsColumn.setCellValueFactory(cellData -> cellData.getValue().yrs_of_expProperty().asObject());
        crewSexColumn.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        crewSIDColumn.setCellValueFactory(cellData -> cellData.getValue().S_idProperty().asObject());
        crewFIDColumn.setCellValueFactory(cellData -> cellData.getValue().F_idProperty().asObject());
        crewPIDColumn.setCellValueFactory(cellData -> cellData.getValue().P_idProperty().asObject());

        ObservableList<String> paramlist = FXCollections.observableArrayList(
                "ID",
                "Name",
                "Years of Exp",
                "Age",
                "Sex",
                "Ship ID",
                "Faction ID",
                "Port ID"
        );
        searchparam.setItems(paramlist);
        searchparam.setValue("ID");
    }*/

    private String parseParam(String param){
        switch(param){
            case "ID":
                return "ID";
            case "Name":
                return "E_name";
            case "Age":
                return "age";
            case "Years of Exp":
                return "yrs_of_exp";
            case "Sex":
                return "sex";
            case "Ship ID":
                return "S_id";
            case "Faction ID":
                return "F_id";
            case "Port ID":
                return "P_id";
        }
        return "";
    }

}
