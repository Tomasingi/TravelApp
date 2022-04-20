package hi.verkefni.travelapp;

import hi.verkefni.traveldata.DataFactory;
import hi.verkefni.traveldata.Flight;
import hi.verkefni.traveldata.Reservation;
import hi.verkefni.traveldata.Seat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightBodyView extends ReservationBodyView {
    private static final double ROW_HEIGHT = 10.0;
    private static final double SEAT_WIDTH = 10.0;
    private static final double AISLE_WIDTH = 10.0;
    private static final double HORIZONTAL_SPACING = 10.0;
    private static final double VERTICAL_SPACING = 10.0;
    private static final double EDGE_PADDING = 15.0;
    private static final double FRONT_PADDING = 15.0;
    private static final double BACK_PADDING = 15.0;

    @FXML
    private StackPane fxStack;
    @FXML
    private VBox fxPlaneBox;

    private final List<Seat> seats;
    private final List<Integer> aisleArrangement = new ArrayList<>();
    private int numRows;
    private double planeWidth = 0;
    private double planeHeight = 0;
    private SeatView selected;

    public FlightBodyView(Reservation reservation, TravelView travelView) {
        this.reservation = reservation;
        this.travelView = travelView;

        seats = ((Flight) reservation).getPlane().getSeats();
        for (Seat seat : seats) {
            seat.setDate(reservation.getDate());
        }
        Random random = new Random();
        int b = random.nextInt(3);
        switch (b) {
            case 0:
                aisleArrangement.add(3);
                aisleArrangement.add(4);
                aisleArrangement.add(3);
                numRows = 2;
                break;
            case 1:
                aisleArrangement.add(1);
                aisleArrangement.add(1);
                numRows = 10;
                break;
            case 2:
                aisleArrangement.add(3);
                aisleArrangement.add(5);
                aisleArrangement.add(4);
                aisleArrangement.add(5);
                aisleArrangement.add(3);
                numRows = 1;
                break;
        }

        planeWidth = EDGE_PADDING + EDGE_PADDING;
        for (Integer i : aisleArrangement) {
            planeWidth += i*SEAT_WIDTH + (i-1)*HORIZONTAL_SPACING;
        }
        planeWidth += (aisleArrangement.size()-1) * (HORIZONTAL_SPACING + AISLE_WIDTH + HORIZONTAL_SPACING);

        planeHeight = FRONT_PADDING + BACK_PADDING;
        planeHeight += numRows*ROW_HEIGHT + (numRows-1)*VERTICAL_SPACING;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("flightbody-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        // Seats
        int counter = 0;
        for (int i = 0; i < numRows; i++) {
            FlightRowView row = new FlightRowView();
            for (int j = 0; j < aisleArrangement.size(); j++) {
                for (int k = 0; k < aisleArrangement.get(j); k++) {
                    try {
                        row.getChildren().add(new SeatView(seats.get(counter), this));
                    } catch (Exception e) {
                        break;
                    }
                    counter++;
                }
                if (j != aisleArrangement.size() - 1) {
                    row.getChildren().add(new AisleView());
                }
            }
            fxPlaneBox.getChildren().add(row);
        }

        // Plane shape
        double hDistance = planeWidth / 2.0;
        double vDistance = planeHeight / 2.0;
        double noseLength = hDistance * 2.0;
        double wingspan = 15.0;
        double aftLength = hDistance * 1.2;
        fxPlaneBox.setMaxHeight(planeHeight);
        fxPlaneBox.setMaxWidth(planeWidth);
        fxPlaneBox.setTranslateY((noseLength - aftLength) / 2.0);

        MoveTo moveTo = new MoveTo(-hDistance, -vDistance);

        // Nose
        double r1 = hDistance * 1.5;
        double r2 = noseLength / Math.sin(Math.acos(1 - hDistance / r1));
        ArcTo nArc1 = new ArcTo(r1, r2, 0.0, 0.0, -vDistance - noseLength, false, true);
        ArcTo nArc2 = new ArcTo(r1, r2, 0.0, hDistance, -vDistance, false, true);

        // Right side
        LineTo rLine1 = new LineTo(hDistance, -vDistance / 5.0);
        LineTo rLine2 = new LineTo(hDistance + wingspan, -vDistance / 6.0);
        LineTo rLine3 = new LineTo(hDistance + wingspan, vDistance / 5.0);
        LineTo rLine4 = new LineTo(hDistance, vDistance / 5.0);
        LineTo rLine5 = new LineTo(hDistance, vDistance);

        // Aft
        double r3 = hDistance * 1.5;
        double r4 = aftLength / Math.sin(Math.acos(1 - hDistance*0.6 / r3));
        ArcTo aArc1 = new ArcTo(r3, r4, 0.0, hDistance * 0.4, vDistance + aftLength, false, true);
        LineTo aLine1 = new LineTo(-hDistance * 0.4, vDistance + aftLength);
        ArcTo aArc2 = new ArcTo(r3, r4, 0.0, -hDistance, vDistance, false, true);

        // Left side
        LineTo lLine1 = new LineTo(-hDistance, vDistance / 5.0);
        LineTo lLine2 = new LineTo(-hDistance - wingspan, vDistance / 5.0);
        LineTo lLine3 = new LineTo(-hDistance - wingspan, -vDistance / 6.0);
        LineTo lLine4 = new LineTo(-hDistance, -vDistance / 5.0);
        LineTo lLine5 = new LineTo(-hDistance, -vDistance);

        Path path = new Path(moveTo, nArc1, nArc2, rLine1, rLine2, rLine3, rLine4, rLine5, aArc1, aLine1, aArc2, lLine1, lLine2, lLine3, lLine4, lLine5);
        path.setStroke(Color.valueOf("#444"));
        path.setStrokeWidth(2);
        path.setFill(Color.valueOf("#FFF"));
        fxStack.getChildren().add(path);
        path.toBack();
    }

    public void select(SeatView seatView) {
        if (selected != null) {
            selected.deselect();
        }
        selected = seatView;
    }

    public void addReservation(SeatView seatView) {
        travelView.addReservation(seatView);
    }

    public void removeReservation(SeatView seatView) {
        travelView.removeReservation(seatView);
    }
}
