package hi.verkefni.travelapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class FlightRowView extends HBox {

    public FlightRowView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("flightrow-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
