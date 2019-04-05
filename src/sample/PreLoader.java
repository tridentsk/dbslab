//package sample;
//
//import javafx.application.Preloader;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//public class PreLoader extends Preloader {
//    private Stage preStage;
//    private Scene scene;
//    PreLoader(){
//
//    }
//
//    @Override
//    public void init() throws Exception{
//        Parent root1 = FXMLLoader.load(getClass().getResource("splash.fxml"));
//        scene = new Scene(root1);
//    }
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        this.preStage = primaryStage;
//        preStage.setScene(scene);
//        preStage.initStyle(StageStyle.UNDECORATED);
//        preStage.show();
//    }
//
//    @Override
//    public void handleApplicationNotification(Preloader.PreloaderNotification info){
//            if(info instanceof ProgressNotification){
////                preloader.loading.setText(((ProgressNotification) info).getProgress());
//            }
//    }
//
//    @Override
//    public void handleStateChangeNotification(Preloader.StateChangeNotification info){
//            StateChangeNotification.Type type  = info.getType();
//            switch(type){
//                case BEFORE_START:
//                    System.out.println("before start");
//                    preStage.hide();
//                    break;
//
//            }
//    }
//}
