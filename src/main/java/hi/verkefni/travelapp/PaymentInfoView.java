package hi.verkefni.travelapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PaymentInfoView extends VBox {
    public PaymentInfoView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paymentinfo-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
