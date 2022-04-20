package hi.verkefni.travelapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class AisleView extends Rectangle {

    public AisleView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("aisle-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        this.visibleProperty().setValue(false);
    }
}
