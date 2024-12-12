package Util;

import DAO.CasaDAO;
import DAO.GenericDAO;
import DAO.PersonaDAO;
import DAO.TransaccionDAO;


import java.util.Date;
import java.util.List;

public class TestGenericDao {
    public static void main(String[] args) {
        // Crear DAO genérico
        GenericDAO<CasaDAO> casaDAO = new GenericDAO<>(CasaDAO.class);
        GenericDAO<TransaccionDAO> transaccionDAO = new GenericDAO<>(TransaccionDAO.class);
        GenericDAO<PersonaDAO> p2 = new GenericDAO<>(PersonaDAO.class);

        try {
            // 1. Crear una Casa (que también es una Propiedad)
            CasaDAO casa = new CasaDAO();
            casa.setDireccion("Calle Falsa 123");
            casa.setPlano("/rutas/plano1.pdf");
            casa.setMoneda("USD");
            casa.setFormaPago("Contado");
            casa.setEstado("Disponible");
            casa.setFotos(List.of(new String[]{"/rutas/foto1.jpg", "/rutas/foto2.jpg"}));
            casa.setNotas("Propiedad en excelente estado.");
            PersonaDAO p = new PersonaDAO(); p.setID(1);
            casa.setDuenio(p); // Supongamos que el ID del dueño es 1

            // Campos específicos de la Casa
            casa.setM2Cubiertos(120);
            casa.setM2Descubiertos(50);
            casa.setAmbientes("3 dormitorios, 2 baños, cocina, sala");
            casa.setEstadoProp("Lista para habitar");
            casa.setServicios_comodidades("Agua, Luz, Gas, Internet");
            casa.setPrecio_Venta_Alquiler(150000.0);

            casaDAO.create(casa);

            System.out.println("Casa creada con éxito. ID: " + casa.getID());

            //2. Comprador para la casa
            int compradorID = 2; // Suponemos que este ID ya existe en la BD
            PersonaDAO comprador = p2.read(compradorID);

            if (comprador == null) {
                System.out.println("El comprador con ID " + compradorID + " no existe.");
                return; // Finaliza si no se encuentra el comprador
            }

            System.out.println("Persona encontrada: " + comprador.getNombreCompleto());


            // 3. Crear una Transacción para la Casa
            TransaccionDAO transaccion = new TransaccionDAO();
            transaccion.setComprador(comprador);
            transaccion.setInmueble(casa);
            transaccion.setFecha(new Date().toString());
            transaccion.setMonto(140000.0);

            transaccionDAO.create(transaccion);

            System.out.println("Transacción creada con éxito. ID: " + transaccion.getID());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
