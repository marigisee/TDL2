package practica7.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import practica7.data;

public class connectionDB {
    protected Connection conexion;

    private String url;
    private String user;
    private String password;

    public connectionDB() {
    }

    public connectionDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void conectar() {
        try {
            if (conexion == null || conexion.isClosed()) {
                // Establecer la conexión si no está inicializada o está cerrada
                conexion = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public void cerrar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}

