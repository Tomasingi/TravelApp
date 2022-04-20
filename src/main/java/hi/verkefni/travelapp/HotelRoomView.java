package hi.verkefni.travelapp;

import hi.verkefni.traveldata.Reservation;
import hi.verkefni.traveldata.Room;
import hi.verkefni.traveldata.RoomAvailability;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class HotelRoomView extends HBox {
    @FXML
    private Label fxDate;
    @FXML
    private Label fxPrice;

    private RoomAvailability roomAvailability;

    public HotelRoomView(RoomAvailability roomAvailability) {
        this.roomAvailability = roomAvailability;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hotelroom-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        fxDate.setText(roomAvailability.getDate().toString());
        fxPrice.setText("   " + roomAvailability.getPrice());
    }

    public RoomAvailability getRoomAvailability() {
        return roomAvailability;
    }
}
