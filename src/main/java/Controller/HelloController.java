package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField inputField;

    @FXML
    private Button actionButton;

    @FXML
    public void onButtonClick() {
        String text = inputField.getText();
        System.out.println("Texto ingresado: " + text);
    }
}

