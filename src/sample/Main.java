package sample;

import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.util.DBUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Parent root;
    //private AnchorPane loginPane;
    @FXML
    private TextField usern;
    @FXML
    private PasswordField passwd;

    @FXML
    private Button loginbtn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Seaways Marine Management System");
        //initRootLayout();
        showLogin();
        //showCrewView();
        //primaryStage.getIcons().add(new Image("icon.png"));

    }
//    @Override
//    public void init() throws Exception{
//        LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(2.0));
//    }

    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout,655,495);
            primaryStage = new Stage();
            primaryStage.setTitle("Seaways Marine Management System");//We are sending rootLayout to the Scene.
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

    public void showLogin(){
        try {
            //First, load CrewView from CrewView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("login.fxml"));
            //AnchorPane CrewOpsView = (AnchorPane) loader.load();
            root = loader.load();
            Scene scene = new Scene(root,500,200);
            primaryStage.setScene(scene); //Set the scene in primary stage.
            primaryStage.setResizable(false);
            /*//Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);*/
            //Third, show the primary stage
            primaryStage.show();
            // Set Crew Operations view into the center of root layout.
            //rootLayout.setCenter(CrewOpsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private boolean loginUser() throws SQLException, Exception{
        String username = usern.getText();
        String password = passwd.getText();
        String qry = "select passwd from auth_user where username=\'" + username + "\'";
        ResultSet rs = DBUtil.dbExecuteQuery(qry);
        if(rs.isBeforeFirst()==false)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Incorrect username or password");
            alert.setContentText("Please check your login credentials");
            alert.showAndWait();
            usern.setText("");
            passwd.setText("");
        }
        while(rs.next()){
            if(rs.getString(1).equals(password))
            {
                Stage stage = (Stage) loginbtn.getScene().getWindow();
                stage.close();
                initRootLayout();
                showCrewView();
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Incorrect username or password");
                alert.setContentText("Please check your login credentials");
                alert.showAndWait();
                usern.setText("");
                passwd.setText("");
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
