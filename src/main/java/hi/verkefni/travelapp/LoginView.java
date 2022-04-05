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
    }

    private void toggleEmailError(boolean b) {
        if (b) {
            fxEmailError.setText("Email required");
        } else {
            fxEmailError.setText("");
        }
    }

    private void togglePasswordError(boolean b) {
        if (b) {
            fxPasswordError.setText("Incorrect password");
        } else {
            fxPasswordError.setText("");
        }
    }

    public void loginHandler() {
        boolean failed = false;

        if (fxEmail.getText().equals("")) {
            toggleEmailError(true);
            failed = true;
        } else {
            toggleEmailError(false);
        }
        if (fxPassword.getText().equals("")) {
            togglePasswordError(true);
            failed = true;
        } else {
            togglePasswordError(false);
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
