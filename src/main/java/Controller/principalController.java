package Controller;

import DAO.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import DAO.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class principalController {
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabViewProperties, tabModifyProperty;
    @FXML
    private TableView<PropiedadDAO> tableView;
    @FXML
    private TableColumn<PropiedadDAO, String> colDireccion;
    @FXML
    private TableColumn<PropiedadDAO, String> colEstado;
    @FXML
    private TableColumn<PropiedadDAO, String> colTipo;
    @FXML
    private TableColumn<PropiedadDAO, String> colDuenio;
    @FXML
    private TableColumn<PropiedadDAO, String> colInquilino;
    private final GenericDAO<PropiedadDAO> propiedadDAO = new GenericDAO<>(PropiedadDAO.class);
    @FXML
    private ComboBox<String> cbTipoPropiedad, cbMoneda, cbMonedaVer;
    @FXML
    private TextField tfDireccion, tfPrecio, tfEstado, tfNombreDuenio, tfDNIDuenio, tfCelularDuenio, tfAmbientes, tfM2Cubiertos, tfM2Descubiertos, tfNombreInquilino, tfDNIInquilino, tfCelularInquilino, tfNotas, tfBuscador, tfPrecioVer, tfEstadoVer, tfNombreDuenioVer, tfDNIDuenioVer, tfCelularDuenioVer, tfNombreInquilinoVer, tfDNIInquilinoVer, tfCelularInquilinoVer, tfNotasVer;
    @FXML
    private Label lblImagenesSeleccionadas, lblImagenesSeleccionadasVer, lblPropiedadSeleccionada,lblFotos,lblDireccion;
    @FXML
    private Button btnSeleccionarImagen, btnSeleccionarImagenVer, btnActualizarPropiedad, btnVerModificarProp, btnBorrarProp;
    @FXML
    private GridPane gridPaneVer;
    @FXML
    private final GenericDAO<PersonaDAO> personaDAO = new GenericDAO<>(PersonaDAO.class);
    @FXML
    private ImageView VerImg1,VerImg2,VerImg3;

    private List<String> rutaImagenesSeleccionadas = null; // Guardará la ruta del archivo seleccionado

    @FXML
    public void initialize() {
        // 📌 Nueva columna para el tipo de propiedad
        colTipo.setCellValueFactory(cellData -> {
            PropiedadDAO propiedad = cellData.getValue();
            String tipo = obtenerTipoPropiedad(propiedad);
            return new javafx.beans.property.SimpleStringProperty(tipo);
        });
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colDuenio.setCellValueFactory(cellData ->
                cellData.getValue().getDuenio() != null ?
                        javafx.beans.property.SimpleStringProperty.stringExpression(
                                javafx.beans.binding.Bindings.createStringBinding(() -> cellData.getValue().getDuenio().getNombreCompleto())
                        ) :
                        javafx.beans.property.SimpleStringProperty.stringExpression(javafx.beans.binding.Bindings.createStringBinding(() -> "Sin dueño"))
        );
        colInquilino.setCellValueFactory(cellData ->
                cellData.getValue().getInquilino() != null ?
                        javafx.beans.property.SimpleStringProperty.stringExpression(
                                javafx.beans.binding.Bindings.createStringBinding(() -> cellData.getValue().getInquilino().getNombreCompleto())
                        ) :
                        javafx.beans.property.SimpleStringProperty.stringExpression(javafx.beans.binding.Bindings.createStringBinding(() -> "Sin inquilino"))
        );

        cargarDatos();
        // Ocultar los botones al iniciar
        btnVerModificarProp.setVisible(false);
        btnBorrarProp.setVisible(false);
        gridPaneVer.setVisible(false);
        lblFotos.setVisible(false);
        lblDireccion.setVisible(false);

        // Listener para detectar selección en la tabla
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Si hay una propiedad seleccionada, mostrar los botones
                btnVerModificarProp.setVisible(true);
                btnBorrarProp.setVisible(true);
            } else {
                // Si no hay selección, ocultar los botones
                btnVerModificarProp.setVisible(false);
                btnBorrarProp.setVisible(false);
            }
        });

        tabViewProperties.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) { // Si la pestaña se seleccionó
                cargarDatos(); // Metodo que recarga la tabla
            }
        });

        tabModifyProperty.selectedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) { // Si la pestaña se cambia
                LimpiarModificar();
            }
        });



    }

    private String obtenerTipoPropiedad(PropiedadDAO propiedad) {
        if (propiedad instanceof CasaDAO) {
            return "Casa";
        } else if (propiedad instanceof DepartamentoDAO) {
            return "Departamento";
        } else if (propiedad instanceof LocalComercialDAO) {
            return "Local Comercial";
        } else if (propiedad instanceof Terreno_LoteDAO) {
            return "Terreno/Lote";
        } else {
            return "Desconocido";
        }
    }


    @FXML
    public void cargarDatos() {
        tfBuscador.clear();
        ObservableList<PropiedadDAO> propiedades = FXCollections.observableArrayList(propiedadDAO.readAll());
        tableView.setItems(propiedades);
    }

    @FXML
    public void ImagenAdd() {
        seleccionarImagenes(1);
    }

    @FXML
    public void ImagenVer() {
        seleccionarImagenes(0);
    }

    public void seleccionarImagenes(int token) {
        int i = 0;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imágenes");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg")
        );
        List<File> archivosSeleccionados = null;
        if (token == 1)
            archivosSeleccionados = fileChooser.showOpenMultipleDialog(btnSeleccionarImagen.getScene().getWindow());
        else
            archivosSeleccionados = fileChooser.showOpenMultipleDialog(btnSeleccionarImagenVer.getScene().getWindow());

        if (archivosSeleccionados != null) {
            List<String> rutasGuardadas = new ArrayList<>();

            try {
                Path directorioDestino = Paths.get("src/main/resources/images/properties/");
                if (!Files.exists(directorioDestino)) {
                    Files.createDirectories(directorioDestino);
                }

                for (File file : archivosSeleccionados) {
                    // Generar un nombre único
                    i++;
                    String nombreArchivo;
                    Path destino;
                    if(token==1) {
                        nombreArchivo = tfDireccion.getText() + "_" + i;
                        destino = directorioDestino.resolve(nombreArchivo);
                    }
                    else{
                        nombreArchivo = lblDireccion.getText() + "_" + i;
                        destino = directorioDestino.resolve(nombreArchivo);
                    }

                    // Copiar el archivo
                    Files.copy(file.toPath(), destino, StandardCopyOption.REPLACE_EXISTING);

                    // Agregar la ruta relativa a la lista
                    rutasGuardadas.add("src/main/resources/images/properties/" + nombreArchivo);
                }

                // Guardamos la lista de rutas en la propiedad
                rutaImagenesSeleccionadas = rutasGuardadas;

                // Mostrar la cantidad de imágenes seleccionadas en la UI
                if (token == 1)
                    lblImagenesSeleccionadas.setText("Imágenes seleccionadas: " + rutasGuardadas.size());
                else
                    lblImagenesSeleccionadasVer.setText("Imágenes seleccionadas: " + rutasGuardadas.size());
            } catch (IOException e) {
                mostrarAlerta("Error", "No se pudieron copiar las imágenes: " + e.getMessage());
            }
        }
    }


    @FXML
    public void guardarPropiedad() {
        try {
            // Obtener valores de los campos
            String tipo = cbTipoPropiedad.getValue();
            String direccion = tfDireccion.getText().trim();
            String precioTexto = tfPrecio.getText().trim();
            String estado = tfEstado.getText().trim();
            String notas = tfNotas.getText().trim();
            String nombreDuenio = tfNombreDuenio.getText().trim();
            String DNIDuenioTexto = tfDNIDuenio.getText().trim();
            String CelularDuenioTexto = tfCelularDuenio.getText().trim();
            String ambientes = tfAmbientes.getText().trim();
            String moneda = cbMoneda.getValue();
            String M2CubiertosTexto = tfM2Cubiertos.getText().trim();
            String M2DescubiertosTexto = tfM2Descubiertos.getText().trim();
            String nombreInquilino = tfNombreInquilino.getText().trim();
            String DNIInquilinoTexto = tfDNIInquilino.getText().trim();
            String CelularInquilinoTexto = tfCelularInquilino.getText().trim();

            // Validar campos obligatorios
            if (tipo == null || direccion.isEmpty() || precioTexto.isEmpty() || estado.isEmpty() || nombreDuenio.isEmpty() || DNIDuenioTexto.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos obligatorios (*) deben completarse.");
                return;
            }

            // Validar formato numérico del precio y metros cuadrados
            double precio;
            int M2Cubiertos = 0, M2Descubiertos = 0;
            try {
                precio = Double.parseDouble(precioTexto);
                if (!M2CubiertosTexto.isEmpty() && !M2DescubiertosTexto.isEmpty()) {
                    M2Cubiertos = Integer.parseInt(M2CubiertosTexto);
                    M2Descubiertos = Integer.parseInt(M2DescubiertosTexto);
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "El precio y los M2s (pueden estar vacios los m2s) deben ser un número válido.");
                return;
            }

            // Buscar o crear dueño
            PersonaDAO duenio = personaDAO.readAll().stream()
                    .filter(p -> p.getNombreCompleto().equalsIgnoreCase(nombreDuenio))
                    .findFirst()
                    .orElseGet(() -> {
                        PersonaDAO nuevaPersona = new PersonaDAO();
                        nuevaPersona.setNombreCompleto(nombreDuenio);
                        nuevaPersona.setDNI_CUIT_CUIL(DNIDuenioTexto);
                        nuevaPersona.setTelefono(CelularDuenioTexto);
                        personaDAO.create(nuevaPersona);
                        return nuevaPersona;
                    });

            // Buscar o crear inquilino si está presente
            PersonaDAO inquilino = null;
            if (!nombreInquilino.isEmpty()) {
                inquilino = personaDAO.readAll().stream()
                        .filter(p -> p.getNombreCompleto().equalsIgnoreCase(nombreInquilino))
                        .findFirst()
                        .orElseGet(() -> {
                            PersonaDAO nuevaPersona = new PersonaDAO();
                            nuevaPersona.setNombreCompleto(nombreInquilino);
                            nuevaPersona.setDNI_CUIT_CUIL(DNIInquilinoTexto);
                            nuevaPersona.setTelefono(CelularInquilinoTexto);
                            personaDAO.create(nuevaPersona);
                            return nuevaPersona;
                        });
            }

            // Crear instancia de la propiedad según el tipo
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

            // Asignar valores a la propiedad (GPT EXPLICITAMENTE)
            nuevaPropiedad.setDireccion(direccion);
            nuevaPropiedad.setPrecio_Venta_Alquiler(precio);
            nuevaPropiedad.setEstado(estado);
            nuevaPropiedad.setNotas_servicios_comodidades(notas);
            nuevaPropiedad.setDuenio(duenio);
            nuevaPropiedad.setInquilino(inquilino);
            nuevaPropiedad.setFotos(rutaImagenesSeleccionadas);
            nuevaPropiedad.setMoneda(moneda);
            nuevaPropiedad.setM2Cubiertos(M2Cubiertos);
            nuevaPropiedad.setM2Descubiertos(M2Descubiertos);
            nuevaPropiedad.setAmbientes(ambientes);

            // Guardar en la base de datos
            propiedadDAO.create(nuevaPropiedad);
            mostrarAlerta("Éxito", "Propiedad guardada correctamente.");

            // Limpiar los campos
            tfDireccion.clear();
            tfPrecio.clear();
            cbTipoPropiedad.setValue(null);
            tfEstado.clear();
            tfNombreDuenio.clear();
            tfDNIDuenio.clear();
            tfCelularDuenio.clear();
            tfNombreInquilino.clear();
            tfDNIInquilino.clear();
            tfCelularInquilino.clear();
            tfM2Cubiertos.clear();
            tfM2Descubiertos.clear();
            tfAmbientes.clear();
            cbMoneda.setValue(null);
            tfNotas.clear();
            if (rutaImagenesSeleccionadas != null) {
                rutaImagenesSeleccionadas.clear();
            }
            lblImagenesSeleccionadas.setText("Ninguna imagen seleccionada");

        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un error inesperado: " + e.getMessage());
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
        String tipo = obtenerTipoPropiedad(propiedadSeleccionada);
        confirmacion.setTitle("Confirmar Eliminación");
        confirmacion.setHeaderText("¿Está seguro de que desea eliminar esta propiedad?");
        confirmacion.setContentText("Tipo de Propiedad: " + tipo + "\nDirección: " + propiedadSeleccionada.getDireccion() +
                "\nDueño: " + propiedadSeleccionada.getDuenio().getNombreCompleto() +
                "\nInquilino: " + (propiedadSeleccionada.getInquilino() != null ? propiedadSeleccionada.getInquilino().getNombreCompleto() : "Sin Inquilino"));

        // Mostrar la alerta y esperar la respuesta del usuario
        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Guardar referencias del dueño e inquilino antes de eliminar la propiedad
                PersonaDAO duenio = propiedadSeleccionada.getDuenio();
                PersonaDAO inquilino = propiedadSeleccionada.getInquilino();

                // Eliminar la propiedad de la base de datos
                propiedadDAO.delete(propiedadSeleccionada.getID());

                // Si la propiedad que se estaba viendo detallada es la q se borra, limpiar esa ventana
                if (propiedadSeleccionada.getDireccion().equalsIgnoreCase(lblDireccion.getText()))
                    LimpiarModificar();

                // Verificar si el dueño no tiene más propiedades y eliminarlo si es necesario
                if (propiedadDAO.contarPropiedadesPorPersona(duenio.getID()) == 0) {
                    personaDAO.delete(duenio.getID());
                }

                // Verificar si el inquilino no tiene más propiedades y eliminarlo si es necesario
                if (inquilino != null && propiedadDAO.contarPropiedadesPorPersona(inquilino.getID()) == 0) {
                    personaDAO.delete(inquilino.getID());
                }

                // Actualizar la tabla
                cargarDatos();

                // Ocultar botones
                btnVerModificarProp.setVisible(false);
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
        if (propiedadesFiltradas.isEmpty()) {
            mostrarAlerta("Búsqueda finalizada", "No hay propiedades cargadas que coincidan con: " + "\"" + busqueda + "\"");
        }
    }



    @FXML
    public void VerPropiedadDetallada() throws MalformedURLException {
        // Limpiar Formulario
        tfPrecioVer.clear();
        tfEstadoVer.clear();
        tfNombreDuenioVer.clear();
        tfDNIDuenioVer.clear();
        tfCelularDuenioVer.clear();
        cbMonedaVer.setValue(null);
        tfNombreInquilinoVer.clear();
        tfDNIInquilinoVer.clear();
        tfCelularInquilinoVer.clear();
        tfNotasVer.clear();
        // Obtener la propiedad seleccionada de la tabla
        PropiedadDAO propiedadSeleccionada = tableView.getSelectionModel().getSelectedItem();
        propiedadSeleccionada = propiedadDAO.getPropiedadConFotos(propiedadSeleccionada.getID());
        lblImagenesSeleccionadasVer.setText("Ninguna Imagen Seleccionada.");
        gridPaneVer.setVisible(true);
        if(propiedadSeleccionada.getFotos() != null && !propiedadSeleccionada.getFotos().isEmpty())
            lblFotos.setVisible(true);
        lblDireccion.setText(propiedadSeleccionada.getDireccion());
        lblPropiedadSeleccionada.setText(obtenerTipoPropiedad(propiedadSeleccionada) + " con dirección: " + lblDireccion.getText());
        VerImg1.setVisible(true);
        VerImg2.setVisible(true);
        VerImg3.setVisible(true);

        if (propiedadSeleccionada == null) {
            mostrarAlerta("Advertencia", "Debe seleccionar una propiedad para ver.");
            return;
        }

        // Cambiar al tab de modificar propiedad
        tabPane.getSelectionModel().select(tabModifyProperty);
        tfPrecioVer.setText(String.valueOf(propiedadSeleccionada.getPrecio_Venta_Alquiler()));
        tfEstadoVer.setText(propiedadSeleccionada.getEstado());
        tfNombreDuenioVer.setText(propiedadSeleccionada.getDuenio().getNombreCompleto());
        tfDNIDuenioVer.setText(propiedadSeleccionada.getDuenio().getDNI_CUIT_CUIL());
        tfCelularDuenioVer.setText(propiedadSeleccionada.getDuenio().getTelefono());
        cbMonedaVer.setValue(propiedadSeleccionada.getMoneda());

        if (propiedadSeleccionada.getInquilino() != null) {
            tfNombreInquilinoVer.setText(propiedadSeleccionada.getInquilino().getNombreCompleto());
            tfDNIInquilinoVer.setText(propiedadSeleccionada.getInquilino().getDNI_CUIT_CUIL());
            tfCelularInquilinoVer.setText(propiedadSeleccionada.getInquilino().getTelefono());
        }

        tfNotasVer.setText(propiedadSeleccionada.getNotas_servicios_comodidades());


        // Cargar imágenes si existen
        List<String> imagenes = propiedadSeleccionada.getFotos();

        if (imagenes != null && !imagenes.isEmpty()) {
            // Asignar imágenes a los ImageView (asegurarse de que sean nodos en el FXML)
            if (imagenes.size() > 0) {
                VerImg1.setImage(new Image(new File(imagenes.getFirst()).toURI().toURL().toExternalForm()));
            } else {
                VerImg1.setImage(null);
            }

            if (imagenes.size() > 1) {
                VerImg2.setImage(new Image(new File(imagenes.get(1)).toURI().toURL().toExternalForm()));
            } else {
                VerImg2.setImage(null);
            }
            if (imagenes.size() > 2) {
                VerImg3.setImage(new Image(new File(imagenes.get(2)).toURI().toURL().toExternalForm()));
            } else {
                VerImg3.setImage(null);
            }
        } else {
            VerImg1.setImage(null);
            VerImg2.setImage(null);
            VerImg3.setImage(null);
        }
    }




    @FXML
    public void modificarPropiedad() {
        PropiedadDAO propiedadModificada = tableView.getSelectionModel().getSelectedItem();
        propiedadModificada = propiedadDAO.getPropiedadConFotos(propiedadModificada.getID());

        propiedadModificada.setPrecio_Venta_Alquiler(Double.parseDouble(tfPrecioVer.getText()));
        propiedadModificada.setEstado(tfEstadoVer.getText());
        propiedadModificada.setMoneda(cbMonedaVer.getValue());
        propiedadModificada.setNotas_servicios_comodidades(tfNotasVer.getText());

        // Buscar o crear dueño
        PersonaDAO duenio = personaDAO.readAll().stream()
                .filter(p -> p.getNombreCompleto().equalsIgnoreCase(tfNombreDuenioVer.getText()))
                .findFirst()
                .orElseGet(() -> {
                    PersonaDAO nuevaPersona = new PersonaDAO();
                    nuevaPersona.setNombreCompleto(tfNombreDuenioVer.getText());
                    nuevaPersona.setDNI_CUIT_CUIL(tfDNIDuenioVer.getText());
                    nuevaPersona.setTelefono(tfCelularDuenioVer.getText());
                    try {
                        personaDAO.create(nuevaPersona);
                    }catch(Exception e){
                        mostrarAlerta("Error","Ya existe una persona con el DNI: " + tfDNIDuenioVer.getText());
                    }
                    return nuevaPersona;
                });

        propiedadModificada.setDuenio(duenio);
        propiedadModificada.getDuenio().setNombreCompleto(tfNombreDuenioVer.getText());
        propiedadModificada.getDuenio().setDNI_CUIT_CUIL(tfDNIDuenioVer.getText());
        propiedadModificada.getDuenio().setTelefono(tfCelularDuenioVer.getText());
        duenio.setNombreCompleto(tfNombreDuenioVer.getText());
        duenio.setDNI_CUIT_CUIL(tfDNIDuenioVer.getText());
        duenio.setTelefono(tfCelularDuenioVer.getText());
        try {
            personaDAO.update(duenio);
        }catch(Exception e){
            mostrarAlerta("Error","Ya existe una persona con el DNI: " + tfDNIDuenioVer.getText());
        }

        // Buscar o crear inquilino si está presente
        PersonaDAO inquilino = null;
        if (!tfNombreInquilinoVer.getText().isEmpty()) {
            inquilino = personaDAO.readAll().stream()
                    .filter(p -> p.getNombreCompleto().equalsIgnoreCase(tfNombreInquilinoVer.getText()))
                    .findFirst()
                    .orElseGet(() -> {
                        PersonaDAO nuevaPersona = new PersonaDAO();
                        nuevaPersona.setNombreCompleto(tfNombreInquilinoVer.getText());
                        nuevaPersona.setDNI_CUIT_CUIL(tfDNIInquilinoVer.getText());
                        nuevaPersona.setTelefono(tfCelularInquilinoVer.getText());
                        try {
                            personaDAO.create(nuevaPersona);
                        }catch(Exception e){
                            mostrarAlerta("Error","Ya existe una persona con el DNI: " + tfDNIInquilinoVer.getText());
                        }
                        return nuevaPersona;
                    });
        }
        if(inquilino != null){
            propiedadModificada.setInquilino(inquilino);
            propiedadModificada.getInquilino().setNombreCompleto(tfNombreInquilinoVer.getText());
            propiedadModificada.getInquilino().setDNI_CUIT_CUIL(tfDNIInquilinoVer.getText());
            propiedadModificada.getInquilino().setTelefono(tfCelularInquilinoVer.getText());
            inquilino.setNombreCompleto(tfNombreInquilinoVer.getText());
            inquilino.setDNI_CUIT_CUIL(tfDNIInquilinoVer.getText());
            inquilino.setTelefono(tfCelularInquilinoVer.getText());
            try {
                personaDAO.update(inquilino);
            }catch(Exception e){
                mostrarAlerta("Error","Ya existe una persona con el DNI: " + tfDNIInquilinoVer.getText());
            }
        }

        if (rutaImagenesSeleccionadas != null) {
            propiedadModificada.setFotos(rutaImagenesSeleccionadas);
        }

        propiedadDAO.update(propiedadModificada);
        mostrarAlerta("Propiedad Actualizada!","La propiedad con dirección: " + propiedadModificada.getDireccion() + " Fue modificada Correctamente");
        tabPane.getSelectionModel().select(tabViewProperties);
        LimpiarModificar();

    }

    @FXML
    public void LimpiarModificar(){
        lblImagenesSeleccionadasVer.setText("Ninguna Imagen Seleccionada.");
        gridPaneVer.setVisible(false);
        lblPropiedadSeleccionada.setText("No hay propiedad seleccionada.");
        VerImg1.setVisible(false);
        VerImg2.setVisible(false);
        VerImg3.setVisible(false);
        lblFotos.setVisible(false);
        lblDireccion.setVisible(false);
        tfPrecioVer.clear();
        tfEstadoVer.clear();
        tfNombreDuenioVer.clear();
        tfDNIDuenioVer.clear();
        tfCelularDuenioVer.clear();
        cbMonedaVer.setValue(null);
        tfNombreInquilinoVer.clear();
        tfDNIInquilinoVer.clear();
        tfCelularInquilinoVer.clear();
        tfNotasVer.clear();
    }

}


