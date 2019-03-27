package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;

import static sample.util.DBUtil.*;

public class CustomController {
    @FXML
    private TableView customQryTable;
    @FXML
    private TextArea customQryText;
    @FXML
    private TextArea customQryMsgText;

    @FXML
    private void customQryExec() throws SQLException{
        String qry = customQryText.getText();

        ResultSet rs=null;
        try {
            rs = dbExecuteQuery(qry);
        }
        catch(SQLException se){
            int count = 1;
            while (se != null) {
                customQryMsgText.setText("SQLException " + count);
                customQryMsgText.setText("Error Message: " + se.getMessage());
                se = se.getNextException();
                count++;
            }
        }

        int j = fillTableWithRS(rs, customQryTable);
        customQryMsgText.clear();

        if(j==0) {
            customQryMsgText.setText("No tuples matching your query were found");
        }
        else
            customQryMsgText.setText(j + " tuples added.");



    }

    @FXML
    static int fillTableWithRS(ResultSet rs, TableView table) throws SQLException{
        table.getColumns().clear();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        int colNum = rs.getMetaData().getColumnCount();
        for (int i = 0; i < colNum; i++) {
            String namex = rs.getMetaData().getColumnName(i+1);
            TableColumn tc = new TableColumn<>();
            tc.setText(namex);
            final int j = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });
            table.getColumns().add(tc);
            System.out.println("Column:     " + namex);
        }
        int j=0;

        while (rs.next()) {
            j++;
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <=rs.getMetaData().getColumnCount(); i++) {
                //Iterate Column
                row.add(rs.getString(i));
            }

            data.add(row);
        }

        table.setItems(data);
        return j;
    }
}
