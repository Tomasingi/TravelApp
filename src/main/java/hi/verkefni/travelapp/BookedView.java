package hi.verkefni.travelapp;

import hi.verkefni.traveldata.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BookedView extends HBox {
    @FXML
    private ImageView fxIcon;
    @FXML
    private Label fxName;
    @FXML
    private HBox fxRight;
    @FXML
    private Spinner<Integer> fxSpinner;
    @FXML
    private ImageView fxRemove;

    private final Reservation reservation;
    private int index;

    private final TravelView travelView;

    private final SimpleIntegerProperty priceProperty = new SimpleIntegerProperty();
    public SimpleIntegerProperty priceProperty() {
        return priceProperty;
    }

    public BookedView(Reservation reservation, TravelView travelView) {
        this.reservation = reservation;
        this.travelView = travelView;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("booked-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        if (reservation instanceof Seat) {
            fxIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/flight.png")));
        } else if (reservation instanceof RoomAvailability) {
            fxIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/hotel.png")));
        } else if (reservation instanceof DayTour) {
            fxIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/daytour.png")));
        } else return;

        fxName.setText(reservation.getName());

        if (reservation instanceof DayTour) {
            fxSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000));
            fxSpinner.getValueFactory().setValue(1);
            fxSpinner.valueProperty().addListener((obs, oldValue, newValue) ->
                    travelView.updateAmount((newValue - oldValue) * reservation.getPrice()));
        } else {
            fxRight.getChildren().remove(fxSpinner);
            fxSpinner = null;
        }

        fxRemove.setImage(new Image(getClass().getResourceAsStream("images/icons/remove.png")));
    }

    @FXML
    private void removeHandler() {
        if (fxSpinner != null) {
            travelView.updateAmount(-(reservation.getPrice() * fxSpinner.getValue()));
        } else {
            travelView.updateAmount(-reservation.getPrice());
        }
        travelView.remove(reservation);
    }

    public int getAmount() {
        return fxSpinner.getValue();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
