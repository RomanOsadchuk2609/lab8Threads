package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.getIcons().add(new Image("file:myIcon2_2.png"));
        primaryStage.show();
        primaryStage.setOnHidden(event->{
            for(Thread t: Thread.getAllStackTraces().keySet()){
                if(t.getState()==Thread.State.RUNNABLE) t.interrupt();
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
