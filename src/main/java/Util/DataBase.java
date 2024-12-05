package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static void main(String[] args) {
        // URL de la base de datos
        String url = "jdbc:mysql://localhost:3306/martillero"; // Cambia el puerto si no es el predeterminado
        String user = "root"; // Usuario de MySQL (cámbialo si es necesario)
        String password = "admin"; // Contraseña del usuario (ajusta según tu configuración)

        System.out.println("Intentando conectar a la base de datos...");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("¡Conexión exitosa a la base de datos 'martillero'!");
            } else {
                System.out.println("Conexión fallida.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }
}
