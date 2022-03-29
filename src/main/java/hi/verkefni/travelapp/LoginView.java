package hi.verkefni.travelapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LoginView extends VBox {
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxPassword;
    @FXML
    private Label fxEmailError;
    @FXML
    private Label fxPasswordError;

    private TravelController travelController;

    public LoginView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize() {
        fxEmailError.visibleProperty().set(false);
        fxPasswordError.visibleProperty().set(false);
    }

    public void loginHandler() {
        boolean failed = false;

        if (fxEmail.getText().equals("")) {
            fxEmailError.visibleProperty().set(true);
            failed = true;
        } else {
            fxEmailError.visibleProperty().set(false);
        }
        if (fxPassword.getText().equals("")) {
            fxPasswordError.visibleProperty().set(true);
            failed = true;
        } else {
            fxPasswordError.visibleProperty().set(false);
        }

        if (!failed) {
            travelController.travel();
        }
    }

    public void signupHandler() {
        travelController.signup();
    }

    public void addLink(TravelController travelController) {
        this.travelController = travelController;
    }
}
