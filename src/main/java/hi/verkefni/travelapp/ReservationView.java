package hi.verkefni.travelapp;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

public class ReservationView extends VBox {
    @FXML
    private ImageView fxMainIcon;
    @FXML
    private Label fxName;
    @FXML
    private Label fxPrice;
    @FXML
    private Label fxDescription;
    @FXML
    private ImageView fxLandshluti;
    @FXML
    private ImageView fxArrow;
    @FXML
    private ImageView fxLandshluti2;
    @FXML
    private Label fxDates;

    private Reservation reservation;
    private int index;
    private TravelView travelView;

    private final SimpleBooleanProperty selectedProperty = new SimpleBooleanProperty();
    public SimpleBooleanProperty selectedProperty() {
        return selectedProperty;
    }

    public ReservationView(Reservation reservation) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation-view.fxml"));
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

    private void setImageFromLocation(ImageView imageView, String location) {
        switch (location) {
            case TravelLocation.AUSTURLAND:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Austurland.png")));
                break;
            case TravelLocation.NORDURLAND_EYSTRA:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Nordurland_eystra.png")));
                break;
            case TravelLocation.NORDURLAND_VESTRA:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Nordurland_vestra.png")));
                break;
            case TravelLocation.SUDURLAND:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Sudurland.png")));
                break;
            case TravelLocation.SUDURNES:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Sudurnes.png")));
                break;
            case TravelLocation.VESTFIRDIR:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Vestfirdir.png")));
                break;
            case TravelLocation.VESTURLAND:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Vesturland.png")));
                break;
            case TravelLocation.HOFUDBORGARSVAEDID:
                imageView.setImage(new Image(getClass().getResourceAsStream("images/locations/Hofudborgarsvaedid.png")));
                break;
            default:
                break;
        }
    }

    private void setReservation() {
        if (reservation instanceof Flight) {
            fxMainIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/flight.png")));
        } else if (reservation instanceof Hotel) {
            fxMainIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/hotel.png")));
        } else if (reservation instanceof DayTour) {
            fxMainIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/daytour.png")));
        } else return;

        fxName.setText(reservation.getName());
        fxPrice.setText(reservation.getPrice() + "$");
        if (reservation instanceof DayTour) {
            fxDescription.setText(((DayTour) reservation).getType() + ": " + reservation.getDescription());
        } else {
            fxDescription.setText(reservation.getDescription());
        }

        setImageFromLocation(fxLandshluti, reservation.getBeginningLocation().getLocation());

        if (reservation.getEndLocation() != reservation.getBeginningLocation()) {
            fxArrow.setImage(new Image(getClass().getResourceAsStream("images/icons/right-arrow.png")));
            setImageFromLocation(fxLandshluti2, reservation.getEndLocation().getLocation());
        } else {
            this.getChildren().remove(fxArrow);
            this.getChildren().remove(fxLandshluti2);
        }

        if (reservation.getBeginningDate().equals(reservation.getEndDate())) {
            fxDates.setText(reservation.getBeginningDate().toString());
        } else {
            fxDates.setText(reservation.getBeginningDate().toString() + "\n" + reservation.getEndDate().toString());
        }
    }

    public void updateSelected() {
        if (this.selectedProperty().getValue()) {
            this.backgroundProperty().setValue(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            this.backgroundProperty().setValue(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void link(TravelView travelView) {
        this.travelView = travelView;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Reservation getReservation() {
        return  reservation;
    }
}
