package practica7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


// Esta clase fue creada solamente para verificar que se estan realizando las conexiones con la base de datos de manera correcta

public class testConnection {
        public static void main(String[] args) {
            try {
                // Load the JDBC driver class
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection to the MySQL server
                Connection conn = DriverManager.getConnection(" ", " ", " ");

                // Create a statement
                Statement stmt = conn.createStatement();

                // Execute a query
                ResultSet rs = stmt.executeQuery("SELECT * from pais;");

                // Process the result set
                while (rs.next()) {
                    int id = rs.getInt("idpais");
                    String nombre = rs.getString("nombre");
                    System.out.println("id: " + id + ", name: " + nombre);
                }

                // Close the resources
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
