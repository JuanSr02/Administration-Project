package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class primeraEjecucion {

    // Información de conexión a la base de datos
    private static final String DB_URL = "jdbc:mysql://localhost:3306/martillero"; // Cambia si es necesario
    private static final String DB_USER = "root"; // Usuario de MySQL
    private static final String DB_PASSWORD = "admin"; // Contraseña de MySQL

    public static void main(String[] args) {
        String filePath = "src/main/java/Util/tablas.sql"; // Ruta del archivo SQL

        System.out.println("Conectando a la base de datos...");

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Conexión exitosa.");
            executeSQLFromFile(connection, filePath);
            System.out.println("Las tablas se han creado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al conectar o interactuar con la base de datos:");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo SQL:");
            e.printStackTrace();
        }
    }

    private static void executeSQLFromFile(Connection connection, String filePath) throws IOException, SQLException {
        // Leer el archivo SQL línea por línea
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             Statement statement = connection.createStatement()) {

            StringBuilder sql = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Eliminar espacios al principio y final
                if (!line.isEmpty() && !line.startsWith("--")) { // Ignorar líneas vacías o comentarios
                    sql.append(line);
                    // Si la línea termina en punto y coma, ejecuta el comando
                    if (line.endsWith(";")) {
                        statement.execute(sql.toString());
                        sql.setLength(0); // Reiniciar el StringBuilder
                    }
                }
            }
        }
    }
}
