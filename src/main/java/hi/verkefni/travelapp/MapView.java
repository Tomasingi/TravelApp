package hi.verkefni.travelapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MapView extends ImageView {
    public MapView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
