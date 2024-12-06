package Util;

import DAO.GenericDAO;
import DAO.PersonaDAO;

public class Main {
    public static void main(String[] args) {
        GenericDAO<PersonaDAO> PersonaDAODAO = new GenericDAO<>(PersonaDAO.class);

        // Crear
        PersonaDAO PersonaDAO = new PersonaDAO();
        PersonaDAO.setNombreCompleto("Juan Pérez");
        PersonaDAO.setDNI_CUIT_CUIL("20304050607");
        PersonaDAO.setTelefono("123456789");
        PersonaDAO.setEmail("juan@example.com");
        PersonaDAODAO.create(PersonaDAO);

        // Leer
        PersonaDAO fetchedPersonaDAO = PersonaDAODAO.read(5);
        System.out.println("PersonaDAO leída: " + fetchedPersonaDAO.getNombreCompleto());

        // Actualizar
        fetchedPersonaDAO.setTelefono("987654321");
        PersonaDAODAO.update(fetchedPersonaDAO);

        // Eliminar
        PersonaDAODAO.delete(5);
    }
}

