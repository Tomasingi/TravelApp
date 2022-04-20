package hi.verkefni.travelapp;

import hi.verkefni.traveldata.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
    private ImageView fxExpand;
    @FXML
    private ImageView fxLandshluti;
    @FXML
    private ImageView fxArrow;
    @FXML
    private ImageView fxLandshluti2;
    @FXML
    private Label fxDates;

    private ReservationBodyView fxBody;

    private Reservation reservation;
    private int index;
    private boolean expanded = false;

    private TravelView travelView;

    private final SimpleBooleanProperty selectedProperty = new SimpleBooleanProperty();
    public SimpleBooleanProperty selectedProperty() {
        return selectedProperty;
    }

    public ReservationView(Reservation reservation, TravelView travelView) {
        this.reservation = reservation;
        this.travelView = travelView;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("reservation-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        setReservation();
        fxExpand.setImage(new Image(getClass().getResourceAsStream("images/icons/expand.png")));
    }

    private void setImageFromLocation(ImageView imageView, int location) {
        switch (location) {
            case TravelLocation.AUSTURLAND -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Austurland.png")));
            case TravelLocation.NORDURLAND_EYSTRA -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Nordurland_eystra.png")));
            case TravelLocation.NORDURLAND_VESTRA -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Nordurland_vestra.png")));
            case TravelLocation.SUDURLAND -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Sudurland.png")));
            case TravelLocation.SUDURNES -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Sudurnes.png")));
            case TravelLocation.VESTFIRDIR -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Vestfirdir.png")));
            case TravelLocation.VESTURLAND -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Vesturland.png")));
            case TravelLocation.HOFUDBORGARSVAEDID -> imageView.setImage(new Image(getClass().getResourceAsStream("images/small_locations/Hofudborgarsvaedid.png")));
            default -> {}
        }
    }

    private void setReservation() {
        if (reservation instanceof Flight) {
            fxMainIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/flight.png")));
            fxBody = new FlightBodyView(reservation, travelView);
        } else if (reservation instanceof Hotel) {
            fxMainIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/hotel.png")));
            fxBody = new HotelBodyView(reservation, travelView);
        } else if (reservation instanceof DayTour) {
            fxMainIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/daytour.png")));
            fxBody = new DayTourBodyView(reservation, travelView);
        } else return;

        fxName.setText(reservation.getName());
        fxPrice.setText(reservation.getPrice() + " ISK");

        setImageFromLocation(fxLandshluti, reservation.getBeginningLocation().getLocation());

        if (!(reservation.getEndLocation().equals(reservation.getBeginningLocation()))) {
            fxArrow.setImage(new Image(getClass().getResourceAsStream("images/icons/right-arrow.png")));
            setImageFromLocation(fxLandshluti2, reservation.getEndLocation().getLocation());
        } else {
            this.getChildren().remove(fxArrow);
            this.getChildren().remove(fxLandshluti2);
        }

        fxDates.setText(reservation.getDate().toString());
    }

    @FXML
    private void expandHandler() {
        expanded = !expanded;
        fxExpand.rotateProperty().setValue((fxExpand.rotateProperty().getValue() + 180) % 360);
        if (expanded) {
            this.getChildren().add(fxBody);
        } else {
            this.getChildren().remove(fxBody);
        }
    }

    public void updateSelected() {
        if (this.selectedProperty().getValue()) {
            this.backgroundProperty().setValue(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            this.backgroundProperty().setValue(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    public void resize() {
        if (reservation instanceof Hotel) {
            ((HotelBodyView) fxBody).resize();
        }
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
