package Controller;

import DAO.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import DAO.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;


public class principalController {
    @FXML
    private TabPane tabPane;
    @FXML
    private TableView<PropiedadDAO> tableView;
    @FXML
    private TableColumn<PropiedadDAO, String> colDireccion;
    @FXML
    private TableColumn<PropiedadDAO, String> colEstado;
    @FXML
    private TableColumn<PropiedadDAO, Double> colPrecio;
    @FXML
    private TableColumn<PropiedadDAO, String> colDuenio;


    private final GenericDAO<PropiedadDAO> propiedadDAO = new GenericDAO<>(PropiedadDAO.class);

    @FXML
    public void initialize() {
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio_Venta_Alquiler")); // Asegúrate que el getter es correcto
        colDuenio.setCellValueFactory(cellData ->
                cellData.getValue().getDuenio() != null ?
                        javafx.beans.property.SimpleStringProperty.stringExpression(
                                javafx.beans.binding.Bindings.createStringBinding(() -> cellData.getValue().getDuenio().getNombreCompleto())
                        ) :
                        javafx.beans.property.SimpleStringProperty.stringExpression(javafx.beans.binding.Bindings.createStringBinding(() -> "Sin dueño"))
        );

        cargarDatos();
    }

    private void cargarDatos() {
        ObservableList<PropiedadDAO> propiedades = FXCollections.observableArrayList(propiedadDAO.readAll());
        tableView.setItems(propiedades);
    }

    @FXML private ComboBox<String> cbTipoPropiedad;
    @FXML private TextField tfDireccion, tfPrecio, tfEstado, tfDuenio;
    @FXML private TextArea taNotas;
    @FXML private Label lblImagenSeleccionada;
    @FXML private Button btnSeleccionarImagen, btnGuardar;

    private final GenericDAO<PersonaDAO> personaDAO = new GenericDAO<>(PersonaDAO.class);

    private String rutaImagenSeleccionada = null; // Guardará la ruta del archivo seleccionado

    @FXML
    public void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(btnSeleccionarImagen.getScene().getWindow());

        if (file != null) {
            try {
                // Crear la carpeta si no existe
                Path directorioDestino = Paths.get("src/main/resources/images/properties/");
                if (!Files.exists(directorioDestino)) {
                    Files.createDirectories(directorioDestino);
                }

                // Generar un nombre único basado en la fecha y hora
                String nombreArchivo = System.currentTimeMillis() + "_" + file.getName();
                Path destino = directorioDestino.resolve(nombreArchivo);

                // Copiar el archivo a la carpeta del proyecto
                Files.copy(file.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

                // Guardamos la ruta relativa en la base de datos
                rutaImagenSeleccionada = "images/properties/" + nombreArchivo;

                lblImagenSeleccionada.setText(nombreArchivo); // Mostramos el nombre de la imagen seleccionada
            } catch (IOException e) {
                mostrarAlerta("Error", "No se pudo copiar la imagen: " + e.getMessage());
            }
        }
    }

    @FXML
    public void guardarPropiedad() {
        try {
            String tipo = cbTipoPropiedad.getValue();
            String direccion = tfDireccion.getText();
            double precio = Double.parseDouble(tfPrecio.getText());
            String estado = tfEstado.getText();
            String notas = taNotas.getText();
            String duenioNombre = tfDuenio.getText();

            if (direccion.isEmpty() || duenioNombre.isEmpty()) {
                mostrarAlerta("Error", "La dirección y el dueño son obligatorios.");
                return;
            }

            PersonaDAO duenio = personaDAO.readAll().stream()
                    .filter(p -> p.getNombreCompleto().equalsIgnoreCase(duenioNombre))
                    .findFirst()
                    .orElse(null);

            if (duenio == null) {
                mostrarAlerta("Error", "El dueño no existe en la base de datos.");
                return;
            }

            PropiedadDAO nuevaPropiedad;

            switch (tipo) {
                case "Casa":
                    nuevaPropiedad = new CasaDAO();
                    break;
                case "Departamento":
                    nuevaPropiedad = new DepartamentoDAO();
                    break;
                case "Local Comercial":
                    nuevaPropiedad = new LocalComercialDAO();
                    break;
                case "Terreno/Lote":
                    nuevaPropiedad = new Terreno_LoteDAO();
                    break;
                default:
                    mostrarAlerta("Error", "Tipo de propiedad no válido.");
                    return;
            }

            nuevaPropiedad.setDireccion(direccion);
            //nuevaPropiedad.setPrecio_Venta_Alquiler(precio);
            nuevaPropiedad.setEstado(estado);
            nuevaPropiedad.setNotas(notas);
            nuevaPropiedad.setDuenio(duenio);
            nuevaPropiedad.setFotos(List.of(rutaImagenSeleccionada)); // Guardamos la ruta de la imagen

            propiedadDAO.create(nuevaPropiedad);
            mostrarAlerta("Éxito", "Propiedad guardada correctamente.");

            ((Stage) btnGuardar.getScene().getWindow()).close();
        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


}


