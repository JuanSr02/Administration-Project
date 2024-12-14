package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlLocation = getClass().getResource("src/main/resources/Views/hello-view.fxml");
        if (fxmlLocation == null) {
            throw new RuntimeException("No se encontró el archivo hello-view.fxml");
        }
        //FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("C:/Users/juan__000/Desktop/Universidad/Pendientes/Software Daniela/Martillero/src/main/resources/Views/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("JavaFX + Scene Builder");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
