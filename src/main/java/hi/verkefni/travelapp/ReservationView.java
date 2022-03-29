package hi.verkefni.travelapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ReservationView extends VBox {
    @FXML
    private ImageView fxMainIcon;
    @FXML
    private Label fxName;
    @FXML
    private ImageView fxLandshluti;
    @FXML
    private ImageView fxLandshluti2;
    @FXML
    private Label fxDates;

    private Reservation reservation;

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
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Austurland.png")));
                break;
            case TravelLocation.NORDURLAND_EYSTRA:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Nordurland_eystra.png")));
                break;
            case TravelLocation.NORDURLAND_VESTRA:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Nordurland_vestra.png")));
                break;
            case TravelLocation.SUDURLAND:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Sudurland.png")));
                break;
            case TravelLocation.SUDURNES:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Sudurnes.png")));
                break;
            case TravelLocation.VESTFIRDIR:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Vestfirdir.png")));
                break;
            case TravelLocation.VESTURLAND:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Vesturland.png")));
                break;
            case TravelLocation.HOFUDBORGARSVAEDID:
                imageView.setImage(new Image(getClass().getResourceAsStream("myndir/Hofudborgarsvaedid.png")));
                break;
            default:
                break;
        }
    }

    public void setReservation() {
        if (reservation instanceof Flight) {

        } else if (reservation instanceof Hotel) {

        } else if (reservation instanceof DayTour) {

        } else return;

        fxName.setText(reservation.getName());

        setImageFromLocation(fxLandshluti, reservation.getBeginningLocation().getLocation());

        if (reservation.getEndLocation() != reservation.getBeginningLocation()) {
            setImageFromLocation(fxLandshluti2, reservation.getEndLocation().getLocation());
        } else {
            this.getChildren().remove(fxLandshluti2);
        }

        fxDates.setText(reservation.getBeginningDate().toString() + " - " + reservation.getEndDate().toString());
    }
}
