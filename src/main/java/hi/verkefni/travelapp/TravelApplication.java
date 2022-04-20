package hi.verkefni.travelapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TravelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TravelApplication.class.getResource("canvas-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setTitle("The Amazing Travel Application");
        stage.setScene(scene);
        TravelController travelController = fxmlLoader.getController();
        travelController.setStage(stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}