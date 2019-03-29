package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.model.CrewDAO;
import sample.util.DBUtil;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sample.util.DBUtil.dbExecuteQuery;

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
    private ComboBox<String> searchparam;
    @FXML
    private TableView crewTable;
    @FXML
    private AnchorPane crewTab;
    @FXML
    private ComboBox<String> postSearch;
    @FXML
    private TableView postTable;
    @FXML
    private DatePicker voyageFromDate, voyageFromDate1, voyagedatepicker;
    @FXML
    private TableView voyageTable;
    @FXML
    private ComboBox<String> voyagesource, voyagedest, chooseship, choosecargo;
    @FXML
    private TableView shipTable;
    @FXML
    private ComboBox<String> choosefaction;

    @FXML
    private void initialize() {
        crewTable.setRowFactory(tv -> {
            TableRow<ObservableList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    ObservableList<String> rowData = row.getItem();
                    System.out.println(rowData);
                    System.out.println(rowData.getClass());
                    crewIDText.setText(rowData.get(0));
                    crewNameText.setText(rowData.get(1));
                    crewAgeText.setText(rowData.get(2));
                    crewYrsText.setText(rowData.get(3));
                    crewSexText.setText(rowData.get(7));
                    crewSIDText.setText(rowData.get(4));
                    crewPIDText.setText(rowData.get(6));
                    crewFIDText.setText(rowData.get(5));
                }
            });
            return row;
        });

        ObservableList<String> paramlist = FXCollections.observableArrayList(
                "ID",
                "Name",
                "Years of Exp",
                "Age",
                "Sex",
                "Ship Name",
                "Faction Name",
                "Port Name"
        );

        ObservableList<String> postlist = FXCollections.observableArrayList(
          "Captain",
          "1st Mate",
                "Cook",
                "Officer",
                "Medic",
                "Engineer",
                "Seaman"
        );

        ObservableList<String> portlist = FXCollections.observableArrayList(
                "Piota",
                "Macklow",
                "Adria",
                "Chillrend",
                "Arthas",
                "Shadowsong",
                "Chauron",
                "Zerus",
                "Ventrue",
                "Adun",
                "Mar Sara",
                "Vale"
        );
        ObservableList<String> shiplist = FXCollections.observableArrayList(
                "Ainz",
                "Alarak",
                "Alladin",
                "Alphonse",
                "Argonaut",
                "Compton",
                "Crass",
                "Crimson",
                "Dauntless",
                "Enthrall",
                "Jackdaw",
                "Lament",
                "Leviathan",
                "Meltdown",
                "Olympus",
                "Overdose",
                "Overlord",
                "Pride",
                "Tempest",
                "Westdale"
        );

        ObservableList<String> cargolist = FXCollections.observableArrayList(
                "Food",
                "Misc",
                "Ore",
                "Passenger",
                "Timber",
                "Vehicles",
                "Weapons"

        );

        ObservableList<String> factionlist = FXCollections.observableArrayList(
                "Doomsgate",
                        "Templars",
                "Wintersong",
                "Vortex",
                "Symphian Order"
        );

        searchparam.setItems(paramlist);
        searchparam.setValue("ID");
        postSearch.setItems(postlist);
        voyagesource.setItems(portlist);
        voyagedest.setItems(portlist);
        postSearch.setValue("Captain");
        chooseship.setItems(shiplist);
        choosecargo.setItems(cargolist);
        choosefaction.setItems(factionlist);
        voyageFromDate.setValue(LocalDate.of(1800, 1, 1));
        voyageFromDate1.setValue(LocalDate.of(1797, 1, 1));
    }

    @FXML
    private void openCustomWindow(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("customWindow.fxml"));
            AnchorPane customStage = (AnchorPane) fxmlLoader.load();
            Scene scene = new Scene(customStage, 600, 400);
            Stage stage = new Stage();
            stage.setTitle("Custom Query");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }


    @FXML
    private void searchCrew (ActionEvent actionEvent) throws SQLException {
        try {
                String paramval = searchparam.getValue();
                String param = parseParam(paramval);
                String basic = "SELECT * FROM Crew where %s=%s";
                String selectStmt = CrewDAO.formatCrewString(searchCrewByText.getText(), basic, param);
                ResultSet rs = dbExecuteQuery(selectStmt);
                CustomController.fillTableWithRS(rs, crewTable);
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
    private void insertCrew (ActionEvent actionEvent) throws ClassNotFoundException {
        try {
            CrewDAO.insertCrew(getAllDetails());
            ResultSet rs = CrewDAO.searchCrew(crewIDText.getText(), "ID");
            CustomController.fillTableWithRS(rs, crewTable);
            clearTexts();
        } catch (SQLException e) {
            DBUtil.throwError("An SQL Exception occured. Please check the details you have entered",
                    "Error: \n" + e.getMessage());
        }
    }

    @FXML
    private void updateCrew(ActionEvent actionEvent) throws ClassNotFoundException{
        try {
            CrewDAO.updateCrew(getAllDetails());
            ResultSet rs = CrewDAO.searchCrew(getAllDetails()[0], "ID");
            clearTexts();
            CustomController.fillTableWithRS(rs, crewTable);
        } catch (SQLException e) {
                DBUtil.throwError("An SQL Exception occured. Please check the details you have entered",
                        "Error: \n" + e.getMessage());
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

   @FXML
    private void crewShowAll() throws SQLException{
       String stmt = "select * from crew order by ID";
       ResultSet rs = dbExecuteQuery(stmt);
       crewTable.getItems().clear();
       CustomController.fillTableWithRS(rs, crewTable);
    }

    @FXML
    private void postShowAll() throws SQLException{
        String qry = "select * from post";
        ResultSet rs=null;
            rs = dbExecuteQuery(qry);
            CustomController.fillTableWithRS(rs, postTable);
       return;
    }

    @FXML
    private void crewSearchbyPost() throws SQLException{
        String qry = "select * from crew where post_name=" + "\'"+ postSearch.getValue() +"\' order by ID";
        ResultSet rs = null;
        rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, postTable);
       return;
    }

    private String parseParam(String param){
        switch(param){
            case "ID":
                return "ID";
            case "Name":
                return "crew_name";
            case "Age":
                return "age";
            case "Years of Exp":
                return "yrs_of_exp";
            case "Sex":
                return "sex";
            case "Ship Name":
                return "ship_name";
            case "Faction Name":
                return "faction_name";
            case "Port Name":
                return "post_name";
        }
        return "";
    }

    @FXML
    private void showAllVoyagesUntil() throws SQLException{
        LocalDate date = voyageFromDate.getValue();
        String dateString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String qry = "select source_name, dest_name, to_char(dateofj, 'DD-MON-YYYY') as DATE_OF_JOURNEY, ship_name, cargo_type " +
                "from voyage where dateofj<=\'" + dateString + "\'";
        ResultSet rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, voyageTable);
    }

    @FXML
    private void showAllVoyagesBetween() throws SQLException{
        LocalDate date = voyageFromDate.getValue();
        LocalDate date2 = voyageFromDate1.getValue();
        String dateString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String dateString2 = date2.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String qry = "select source_name, dest_name, to_char(dateofj, 'DD-MON-YYYY') as DATE_OF_JOURNEY, ship_name, cargo_type "
                + "from voyage where dateofj>= \'" + dateString2 + "\' and dateofj<=\'" + dateString + "\'";
        ResultSet rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, voyageTable);
    }

    @FXML
    private void showAllVoyagesAfter() throws SQLException{
        LocalDate date = voyageFromDate1.getValue();
        String dateString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String qry = "select source_name, dest_name, to_char(dateofj, 'DD-MON-YYYY') as DATE_OF_JOURNEY, ship_name, cargo_type " +
                " from voyage where dateofj>=\'" + dateString + "\'";
        ResultSet rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, voyageTable);
    }

    @FXML
    private void showVoyagesFrom() throws SQLException{
        String source = voyagesource.getValue();
        String qry = "select source_name, dest_name, to_char(dateofj, 'DD-MON-YYYY') as DATE_OF_JOURNEY, ship_name, cargo_type " +
                " from voyage where source_name=\'"+ source +"\'";
        ResultSet rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, voyageTable);
    }

    @FXML
    private void showVoyagesTo() throws SQLException{
        String dest = voyagedest.getValue();
        String qry = "select source_name, dest_name, to_char(dateofj, 'DD-MON-YYYY') as DATE_OF_JOURNEY, ship_name, cargo_type " +
                " from voyage where dest_name=\'"+ dest +"\'";
        ResultSet rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, voyageTable);
    }

    @FXML
    private void showVoyagesBetweenPorts() throws SQLException{
        String source = voyagesource.getValue();
        String dest = voyagedest.getValue();
        String qry = "select source_name, dest_name, to_char(dateofj, 'DD-MON-YYYY') as DATE_OF_JOURNEY, ship_name, cargo_type " +
                " from voyage where source_name=\'"+ source +"\' and dest_name=\'"
                + dest +"\'";
        ResultSet rs = dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, voyageTable);
    }

    @FXML
    private void insertVoyage() throws SQLException{
        String source = voyagesource.getValue();
        String dest = voyagedest.getValue();
        String ship = chooseship.getValue();
        String cargo = choosecargo.getValue();
        LocalDate date = voyagedatepicker.getValue();
        String dateString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        String qry = "insert into voyage values(" + "'" + source + "','" + dest + "','" + dateString +
                "','" + ship +"','" + cargo + "')";
        try{
            DBUtil.dbExecuteUpdate(qry);
        }
        catch(SQLException e){
            DBUtil.throwError("An SQL Exception occured. Please check the details you have entered",
                    "Error: \n" + e.getMessage());
        }
        showVoyagesBetweenPorts();
    }

    @FXML
    private void searchShipsByFaction() throws SQLException{
        String faction = choosefaction.getValue();
        String qry = "select * from ship where faction_name='" + faction + "'";
        ResultSet rs = DBUtil.dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, shipTable);
    }

    @FXML
    private void showAllShips() throws SQLException{
        String qry = "select * from ship";
        ResultSet rs = DBUtil.dbExecuteQuery(qry);
        CustomController.fillTableWithRS(rs, shipTable);
    }
}



