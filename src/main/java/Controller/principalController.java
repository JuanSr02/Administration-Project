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

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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
    private Button btnModificarProp;
    @FXML
    private Button btnBorrarProp;




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
        // Ocultar los botones al iniciar
        btnModificarProp.setVisible(false);
        btnBorrarProp.setVisible(false);

        // Listener para detectar selección en la tabla
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Si hay una propiedad seleccionada, mostrar los botones
                btnModificarProp.setVisible(true);
                btnBorrarProp.setVisible(true);
            } else {
                // Si no hay selección, ocultar los botones
                btnModificarProp.setVisible(false);
                btnBorrarProp.setVisible(false);
            }
        });
    }

    @FXML
    public void cargarDatos() {
        tfBuscador.clear();
        ObservableList<PropiedadDAO> propiedades = FXCollections.observableArrayList(propiedadDAO.readAll());
        tableView.setItems(propiedades);
    }

    @FXML private ComboBox<String> cbTipoPropiedad;
    @FXML private TextField tfDireccion, tfPrecio, tfEstado, tfDuenio,tfBuscador;
    @FXML private TextArea taNotas;
    @FXML private Label lblImagenesSeleccionadas;
    @FXML private Button btnSeleccionarImagen, btnGuardar;

    private final GenericDAO<PersonaDAO> personaDAO = new GenericDAO<>(PersonaDAO.class);

    private List<String> rutaImagenesSeleccionadas = null; // Guardará la ruta del archivo seleccionado

    @FXML
    public void seleccionarImagenes() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imágenes");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg")
        );

        List<File> archivosSeleccionados = fileChooser.showOpenMultipleDialog(btnSeleccionarImagen.getScene().getWindow());

        if (archivosSeleccionados != null) {
            List<String> rutasGuardadas = new ArrayList<>();

            try {
                Path directorioDestino = Paths.get("src/main/resources/images/properties/");
                if (!Files.exists(directorioDestino)) {
                    Files.createDirectories(directorioDestino);
                }

                for (File file : archivosSeleccionados) {
                    // Generar un nombre único
                    String nombreArchivo = System.currentTimeMillis() + "_" + file.getName();
                    Path destino = directorioDestino.resolve(nombreArchivo);

                    // Copiar el archivo
                    Files.copy(file.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

                    // Agregar la ruta relativa a la lista
                    rutasGuardadas.add("images/properties/" + nombreArchivo);
                }

                // Guardamos la lista de rutas en la propiedad
                rutaImagenesSeleccionadas = rutasGuardadas;

                // Mostrar la cantidad de imágenes seleccionadas en la UI
                lblImagenesSeleccionadas.setText("Imágenes seleccionadas: " + rutasGuardadas.size());

            } catch (IOException e) {
                mostrarAlerta("Error", "No se pudieron copiar las imágenes: " + e.getMessage());
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
            nuevaPropiedad.setPrecio_Venta_Alquiler(precio);
            nuevaPropiedad.setEstado(estado);
            nuevaPropiedad.setNotas_servicios_comodidades(notas);
            nuevaPropiedad.setDuenio(duenio);
            nuevaPropiedad.setFotos(rutaImagenesSeleccionadas); // Guardamos la ruta de la imagen

            propiedadDAO.create(nuevaPropiedad);
            mostrarAlerta("Éxito", "Propiedad guardada correctamente.");

            // Limpiar los campos para agregar otra propiedad
            tfDireccion.clear();
            tfPrecio.clear();
            cbTipoPropiedad.setValue(null);
            tfEstado.clear();
            tfDuenio.clear();
            taNotas.clear();
            if(rutaImagenesSeleccionadas != null)
                rutaImagenesSeleccionadas.clear();
            lblImagenesSeleccionadas.setText("Ninguna imagen seleccionada");// Si hay una lista de fotos, limpiarla también

        } catch (Exception e) {
            mostrarAlerta("Error", "Datos inválidos: " + e.getMessage());
        }
    }

    @FXML
    public void borrarPropiedad() {
        // Obtener la propiedad seleccionada
        PropiedadDAO propiedadSeleccionada = tableView.getSelectionModel().getSelectedItem();

        if (propiedadSeleccionada == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar una propiedad para borrar.");
            return;
        }

        // Crear la alerta de confirmación
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar Eliminación");
        confirmacion.setHeaderText("¿Está seguro de que desea eliminar esta propiedad?");
        confirmacion.setContentText("Dirección: " + propiedadSeleccionada.getDireccion() +
                "\nDueño: " + (propiedadSeleccionada.getDuenio() != null ? propiedadSeleccionada.getDuenio().getNombreCompleto() : "Sin dueño"));

        // Mostrar la alerta y esperar la respuesta del usuario
        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Eliminar la propiedad de la base de datos
                propiedadDAO.delete(propiedadSeleccionada.getID());

                // Actualizar la tabla
                cargarDatos();

                // Ocultar botones
                btnModificarProp.setVisible(false);
                btnBorrarProp.setVisible(false);

                mostrarAlerta("Éxito", "Propiedad eliminada correctamente.");
            }
        });
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    public void buscarPropiedad() {
        String busqueda = tfBuscador.getText().trim().toLowerCase();

        if (busqueda.isEmpty()) {
            cargarDatos(); // Si no se ingresó nada, se cargan todas las propiedades
            return;
        }

        List<PropiedadDAO> todasLasPropiedades = propiedadDAO.readAll();
        ObservableList<PropiedadDAO> propiedadesFiltradas = FXCollections.observableArrayList();

        for (PropiedadDAO propiedad : todasLasPropiedades) {
            if (
                    propiedad.getDireccion().toLowerCase().contains(busqueda) ||
                            (propiedad.getPlano() != null && propiedad.getPlano().toLowerCase().contains(busqueda)) ||
                            (propiedad.getMoneda() != null && propiedad.getMoneda().toLowerCase().contains(busqueda)) ||
                            (propiedad.getFormaPago() != null && propiedad.getFormaPago().toLowerCase().contains(busqueda)) ||
                            (propiedad.getEstado() != null && propiedad.getEstado().toLowerCase().contains(busqueda)) ||
                            (propiedad.getNotas_servicios_comodidades() != null && propiedad.getNotas_servicios_comodidades().toLowerCase().contains(busqueda)) ||
                            (propiedad.getAmbientes() != null && propiedad.getAmbientes().toLowerCase().contains(busqueda)) ||
                            (propiedad.getDuenio() != null && propiedad.getDuenio().getNombreCompleto().toLowerCase().contains(busqueda)) ||
                            (propiedad.getInquilino() != null && propiedad.getInquilino().getNombreCompleto().toLowerCase().contains(busqueda))
            ) {
                propiedadesFiltradas.add(propiedad);
            }
        }

        tableView.setItems(propiedadesFiltradas);
    }



}


