package hi.verkefni.travelapp;

import hi.verkefni.traveldata.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class TravelView extends VBox {
    @FXML
    private VBox fxSearchResults;
    @FXML
    private ImageView fxSearchIcon;
    @FXML
    private CheckBox fxFlightsCheck;
    @FXML
    private CheckBox fxHotelsCheck;
    @FXML
    private CheckBox fxDaytoursCheck;
    @FXML
    private DatePicker fxBeginningDate;
    @FXML
    private DatePicker fxEndDate;
    @FXML
    private TextField fxSearchBar;
    @FXML
    private ChoiceBox<String> fxSortBy;
    @FXML
    private AnchorPane fxMainView;
    @FXML
    private AnchorPane fxSelected;
    @FXML
    private Label fxSubtotal;
    @FXML
    private ImageView fxCart;

    private int subtotal = 0;
    private final List<Reservation> reservations = new ArrayList<>();
    private final List<Reservation> slice = new ArrayList<>();
    private final List<Reservation> selected = new ArrayList<>();
    private final Comparator<Reservation> compareByDate = Comparator.comparing(Reservation::getDate);
    private final Comparator<Reservation> compareByPrice = Comparator.comparing(Reservation::getPrice);
    private final Comparator<Reservation> compareByName = Comparator.comparing(Reservation::getName);
    private TravelController travelController;

    public TravelView() {
        reservations.addAll(DataFactory.selectAllDayTour());
        reservations.addAll(DataFactory.selectAllFlight());
        reservations.addAll(DataFactory.selectAllHotels());
        for (Reservation reservation : reservations) {
            ReservationView reservationView = new ReservationView(reservation, this);
            reservation.setReservationView(reservationView);
            reservationView.setOnMouseClicked(e -> selectHandler(reservationView, e));
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("travel-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        fxSearchIcon.setImage(new Image(getClass().getResourceAsStream("images/icons/search.png")));
        fxCart.setImage(new Image(getClass().getResourceAsStream("images/icons/cart.png")));
    }

    public void searchHandler() {
        slice.clear();

        boolean flights = fxFlightsCheck.isSelected();
        boolean hotels = fxHotelsCheck.isSelected();
        boolean daytours = fxDaytoursCheck.isSelected();
        String[] searchWords = fxSearchBar.getText().toLowerCase().split(" ");

        for (Reservation r : reservations) {
            // Check text
            boolean rightText = true;

            Set<String> matchWords = new HashSet<>();

            String[] nameArray = r.getName().toLowerCase().split(" ");
            matchWords.addAll(Arrays.asList(nameArray));
            String[] descriptionArray = r.getDescription().toLowerCase().split(" ");
            matchWords.addAll(Arrays.asList(descriptionArray));

            matchWords.add(r.getBeginningLocation().getName().toLowerCase());
            matchWords.add(r.getBeginningLocation().getLocationString().toLowerCase());
            matchWords.add(r.getEndLocation().getName().toLowerCase());
            matchWords.add(r.getEndLocation().getLocationString().toLowerCase());

            for (String s : searchWords) {
                if (s != "") {
                    if (!matchWords.contains(s)) {
                        rightText = false;
                        break;
                    }
                }
            }
            if (!rightText) {
                continue;
            }

            // Check type and date restrictions
            boolean rightType = flights && (r instanceof Flight)
                    || hotels && (r instanceof Hotel)
                    || daytours && (r instanceof DayTour)
                    || (!flights && !hotels && !daytours);
            LocalDate lb = fxBeginningDate.getValue();
            LocalDate ub = fxEndDate.getValue();
            LocalDate date = r.getDate();
            boolean notEarly = (lb == null) || (date.isAfter(lb));
            boolean notLate = (ub == null) || (date.isBefore(ub));
            boolean rightDate = notEarly && notLate;
            if (rightType && rightDate) {
                slice.add(r);
            }
        }


        // Sort results
        switch (fxSortBy.valueProperty().getValue()) {
            case "Date" -> slice.sort(compareByDate);
            case "Price" -> slice.sort(compareByPrice);
            default -> slice.sort(compareByName);
        }

        renderSearch();
    }

    public void resize() {
        double offset = 0.0;
        for (Node i : fxMainView.getChildren()) {
            ReservationView view = (ReservationView) i;
            view.setPrefWidth(fxMainView.getWidth());
            view.setLayoutY(offset);
            offset += view.getHeight() * 1.1;
            view.resize();
        }

        offset = 0.0;
        for (Node i : fxSelected.getChildren()) {
            BookedView view = (BookedView) i;
            view.setPrefWidth(fxSelected.getWidth());
            view.setLayoutY(offset);
            offset += view.getHeight() * 1.1;
        }
    }

    private void selectHandler(ReservationView reservationView, MouseEvent e) {
        reservationView.selectedProperty().setValue(true);
        for (Node i : fxMainView.getChildren()) {
            ReservationView view = (ReservationView) i;
            if (view != reservationView) {
                view.selectedProperty().setValue(false);
            }
            view.updateSelected();
        }
        if (reservationView.getReservation() instanceof DayTour) {
            int numClicks = e.getClickCount();
            if (numClicks == 2) {
                Reservation reservation = reservationView.getReservation();
                addReservation(reservation);
            }
        }
    }

    public void addReservation(Reservation reservation) {
        if (!selected.contains(reservation)) {
            selected.add(reservation);
            selected.sort(compareByDate);
            int index = selected.indexOf(reservation);
            BookedView bookedView = new BookedView(reservation, this);
            fxSelected.getChildren().add(index, bookedView);

            subtotal += reservation.getPrice();
            updateSubtotalText();
        }
    }

    public void addReservation(SeatView seatView) {
        addReservation(seatView.getSeat());
    }

    public void removeReservation(SeatView seatView) {
        remove(seatView.getSeat());
    }

    public void addReservation(HotelRoomView hotelRoomView) {
        BookedView bookedView = new BookedView(hotelRoomView.getRoomAvailability(), this);
    }

    public void remove(Reservation reservation) {
        fxSelected.getChildren().remove(selected.indexOf(reservation));
        if (reservation instanceof Seat) {
            ((Seat) reservation).getSeatView().setAvailable();
        }
        selected.remove(reservation);
    }

    private void renderSearch() {
        fxMainView.getChildren().clear();
        for (Reservation r : slice) {
            fxMainView.getChildren().add(r.getReservationView());
        }
    }

    public void updateAmount(int amount) {
        subtotal += amount;
        updateSubtotalText();
    }

    private void calculateSubtotal() {
        int newSubtotal = 0;
        for (Node view : fxSelected.getChildren()) {
            BookedView bookedView = (BookedView) view;
            newSubtotal += bookedView.priceProperty().getValue();
        }
        subtotal = newSubtotal;
        updateSubtotalText();
    }

    private void updateSubtotalText() {
        fxSubtotal.setText("Subtotal: " + subtotal + " ISK");
    }

    public void addLink(TravelController travelController) {
        this.travelController = travelController;
    }

    public void cartHandler() {
        travelController.goToCart(selected);
    }
}
