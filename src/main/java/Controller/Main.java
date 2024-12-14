package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlLocation = Main.class.getResource("newMain.fxml");
        if (fxmlLocation == null) {
            throw new RuntimeException("No se encontró el archivo newMain.fxml");
        }
        //FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("JavaFX + Scene Builder");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
