package hi.verkefni.travelapp;

import hi.verkefni.traveldata.Reservation;
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
    private Spinner<Integer> fxSpinner;
    @FXML
    private ImageView fxRemove;

    private Reservation reservation;
    private int index;
    private TravelView travelView;

    private final SimpleIntegerProperty priceProperty = new SimpleIntegerProperty();
    public SimpleIntegerProperty priceProperty() {
        return priceProperty;
    }

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

    public void initialize() {
        fxSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000));
        fxSpinner.getValueFactory().setValue(1);
        fxSpinner.valueProperty().addListener((obs, oldValue, newValue) ->
                travelView.updateAmount((newValue - oldValue) * reservation.getPrice()));

        fxRemove.setImage(new Image(getClass().getResourceAsStream("images/icons/remove.png")));
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

    @FXML
    private void removeHandler() {
        travelView.remove(reservation);
    }

    @FXML
    private void amountHandler() {
        System.out.println("!");
        travelView.updateAmount();
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

    public void link(TravelView travelView) {
        this.travelView = travelView;
    }
}
