package hi.verkefni.travelapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PaymentView extends VBox {
    private final PaymentInfoView paymentInfoView = new PaymentInfoView();
    private TravelController travelController;

    public PaymentView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("payment-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void addLink(TravelController travelController) {
        this.travelController = travelController;
    }

    public void paymentHandler() {
        this.getChildren().add(paymentInfoView);
    }

    public void backHandler() {
        travelController.travel();
    }
}
