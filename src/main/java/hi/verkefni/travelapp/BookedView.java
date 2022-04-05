package hi.verkefni.travelapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BookedView extends HBox {
    @FXML
    private ImageView fxIcon;
    @FXML
    private Label fxName;

    private Reservation reservation;
    private int index;

    public BookedView(Reservation reservation) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booked-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.reservation = reservation;
        setReservation();
    }

    private void setReservation() {
        if (reservation instanceof Flight) {
            fxIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/flight.png")));
        } else if (reservation instanceof Hotel) {
            fxIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/hotel.png")));
        } else if (reservation instanceof DayTour) {
            fxIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/daytour.png")));

        } else return;

        fxName.setText(reservation.getName());
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
