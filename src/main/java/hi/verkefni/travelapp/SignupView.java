package hi.verkefni.travelapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SignupView extends VBox {
    @FXML
    private TextField fxName;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxPassword;
    @FXML
    private TextField fxConfirmPassword;
    @FXML
    private Label fxNameError;
    @FXML
    private Label fxEmailError;
    @FXML
    private Label fxPasswordError;
    @FXML
    private Label fxConfirmPasswordError;

    private TravelController travelController;

    public SignupView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
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

    private void toggleNameError(boolean b) {
        if (b) {
            fxNameError.setText("Name required");
        } else {
            fxNameError.setText("");
        }
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
            fxPasswordError.setText("Password required");
        } else {
            fxPasswordError.setText("");
        }
    }

    private void toggleConfirmPasswordError(boolean b) {
        if (b) {
            fxConfirmPasswordError.setText("Passwords don't match");
        } else {
            fxConfirmPasswordError.setText("");
        }
    }

    public void createAccountHandler() {
        boolean failed = false;

        if (fxName.getText().equals("")) {
            toggleNameError(true);
            failed = true;
        } else {
            toggleNameError(false);
        }
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
        if (!fxPassword.getText().equals(fxConfirmPassword.getText())) {
            toggleConfirmPasswordError(true);
            failed = true;
        } else {
            toggleConfirmPasswordError(false);
        }

        if (!failed) {
            User newUser = new User(
                    fxName.getText(),
                    fxEmail.getText(),
                    fxPassword.getText()
            );
            travelController.create(newUser);
            travelController.travel();
        }
    }

    public void loginHandler() {
        travelController.login();
    }

    public void addLink(TravelController travelController) {
        this.travelController = travelController;
    }
}
