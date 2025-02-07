package Controller;

import DAO.PropiedadDAO;
import DAO.GenericDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PropiedadController {
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
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("dirección"));
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
}
