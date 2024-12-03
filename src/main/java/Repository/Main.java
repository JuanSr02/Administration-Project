package Repository;


import DAO.PersonaDAO;
import DAO.propiedadDAO;
import Model.Persona;
import org.hibernate.jpa.boot.internal.PersistenceXmlParser;


public class Main {
    public static void main(String[] args) {
        GenericDAO<propiedadDAO> propiedadDAO = new GenericDAO<>(propiedadDAO.class);

        // Crear una nueva propiedad
        propiedadDAO nuevaPropiedad = new propiedadDAO();
        nuevaPropiedad.setDireccion("Calle Falsa 123");
        nuevaPropiedad.setMoneda("USD");
        nuevaPropiedad.setFormaPago("Efectivo");
        nuevaPropiedad.setEstado("Disponible");
        nuevaPropiedad.setFotos("foto1.jpg");
        nuevaPropiedad.setNotas("Propiedad en excelente estado.");
        // Asignar un dueño existente
        PersonaDAO p = new PersonaDAO(1,"Juan Pérez",20304050,1122334455,"juan.perez@gmail.com");
        nuevaPropiedad.setDuenio(p); // Asegúrate de tener un objeto Persona válido.

        propiedadDAO.create(nuevaPropiedad);

        // Leer una propiedad
        propiedadDAO propiedad = propiedadDAO.read(1);
        System.out.println(propiedad);

        // Actualizar una propiedad
        propiedad.setEstado("Reservada");
        propiedadDAO.update(propiedad);

        // Eliminar una propiedad
        propiedadDAO.delete(1);
    }
}

