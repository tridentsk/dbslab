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
    private void customQryExec() throws SQLException {
        String qry = customQryText.getText();
        ObservableList<ObservableList> data = FXCollections.observableArrayList();
        ResultSet rs = dbExecuteQuery(qry);
        customQryTable.getColumns().clear();
        int colNum = rs.getMetaData().getColumnCount();
        for (int i = 0; i < colNum; i++) {
            String name = rs.getMetaData().getColumnName(i+1);
            TableColumn tc = new TableColumn<>();
            tc.setText(name);
            final int j = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());

                }
            });
            customQryTable.getColumns().add(tc);
            System.out.println("Column:     " + name);
        }

        while (rs.next()) {
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <=rs.getMetaData().getColumnCount(); i++) {
                //Iterate Column
                row.add(rs.getString(i));
            }
            System.out.println("Row [1] added " + row);
            data.add(row);
        }

        customQryTable.setItems(data);


    }
}
