package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Hello World");
        initRootLayout();
        showCrewView();

    }

    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout,655,495); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.
            primaryStage.setResizable(false);
            /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCrewView() {
        try {
            //First, load CrewView from CrewView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("CrewView.fxml"));
            AnchorPane CrewOpsView = (AnchorPane) loader.load();
            // Set Crew Operations view into the center of root layout.
            rootLayout.setCenter(CrewOpsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
