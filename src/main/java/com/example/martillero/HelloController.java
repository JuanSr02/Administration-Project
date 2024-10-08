package com.example.martillero;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    public Button Newbotton;
    @FXML
    private Label welcomeText;
    @FXML
    private Label labeljo;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onNewbottonClick() { labeljo.setText("Vamos RIVER!");
    }
}