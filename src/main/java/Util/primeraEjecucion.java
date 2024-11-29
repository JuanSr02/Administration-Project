package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class primeraEjecucion {
    private static final String URL = "jdbc:sqlite:C:/Users/juan__000/Desktop/Universidad/Pendientes/Software Daniela/martilleroDB.db";
    private static final String SQL_FILE_PATH = "C:/Users/juan__000/Desktop/Universidad/Pendientes/Software Daniela/Martillero/src/main/java/Util/Tables.sql";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Establecer conexión con la base de datos
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();

            // Leer el archivo SQL
            BufferedReader reader = new BufferedReader(new FileReader(SQL_FILE_PATH));
            StringBuilder sql = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
            reader.close();

            // Dividir el script en sentencias individuales y ejecutarlas
            String[] sqlStatements = sql.toString().split(";");

            for (String sqlStatement : sqlStatements) {
                if (!sqlStatement.trim().isEmpty()) {
                    statement.execute(sqlStatement.trim());
                    System.out.println("Ejecutada: " + sqlStatement.trim());
                }
            }

            System.out.println("Archivo SQL ejecutado con éxito.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo SQL: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al ejecutar el archivo SQL: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

