package hi.verkefni.travelapp;

import hi.verkefni.traveldata.DayTour;
import hi.verkefni.traveldata.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;

public class DayTourBodyView extends ReservationBodyView {
    @FXML
    private Label fxDescription;

    public DayTourBodyView(Reservation reservation, TravelView travelView) {
        this.reservation = reservation;
        this.travelView = travelView;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("daytourbody-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        fxDescription.setText(((DayTour) reservation).getType() + ": " + reservation.getDescription());
    }
}
