package practica7.dao;

import practica7.interfaces.DAOPais;
import practica7.model.Pais;

import java.sql.SQLException;
import java.util.Scanner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/***
 *
 *  * Ingresar datos básicos de un país. Un país consistirá de:
 *  * ○ nombre
 *  * ○ idioma (Español, Inglés, Portugués, etc).
 *  * Antes de guardar los datos del país se debe verificar que no existe otro país ya
 *  * ingresado con el mismo nombre, caso contrario, debe informarse en pantalla acerca
 *  * del error.
 *
 */

public class DAOPaisImpl implements DAOPais {

    Scanner scanner = new Scanner(System.in);
    private connectionDB c = new connectionDB();

    public DAOPaisImpl(connectionDB c) {
        this.c = c;
    }

    public void setConnectionDB(connectionDB c) {
        this.c = c;
    }

    @Override
    public void insertar(Pais p) {
        try {

            c.conectar();
            System.out.println("Se realizo la conexion");
            PreparedStatement st = c.conexion.prepareStatement("INSERT INTO pais(nombre, idioma) VALUES (?, ?)");
            st.setString(1, p.getNombre());
            st.setString(2, p.getIdioma());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar pais: " + e.getMessage());
        } finally {
            c.cerrar();
        }
    }

    public boolean verificarExistencia(String nombre) {
        boolean existe = false;
        try {

            c.conectar();
            PreparedStatement st = c.conexion.prepareStatement("SELECT * FROM pais WHERE nombre = ?");
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                existe = true;
            }

        } catch (Exception e) {
            System.out.println("Error al verificar existencia: " + e.getMessage());
        } finally {
            c.cerrar();
        }
        return existe;
    }

    public Pais ingresarDatos() {
        System.out.println("Ingrese el nombre del pais");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el idioma del pais");
        String idioma = scanner.nextLine();
        Pais p = new Pais(nombre, idioma);

        return p;
    }

    public void insertarMientras() {
        Pais p = ingresarDatos();
        boolean estaRepetido;
        //La inserción de los datos se realizará mientras el usuario no ingrese un signo de exclamación
        while (!p.getNombre().equals("!")) {
            estaRepetido = verificarExistencia(p.getNombre());
            if (estaRepetido) {
                System.out.println("El pais ya existe");
            } else {
                insertar(p);
            }
            p = ingresarDatos();
        }
    }

    @Override
    public List<Pais> listar() {
        List<Pais> lista = null;
        try {

            //Preparamos la consulta
            PreparedStatement st = c.conexion.prepareStatement("SELECT * FROM pais");
            ResultSet rs = st.executeQuery();

            lista = new ArrayList<>();

            //Recorremos el resultado, mientras haya registros para leer, y llenamos la lista
            while (rs.next()) {
                Pais p = new Pais();
                p.setIdpais(rs.getInt("idpais"));
                p.setNombre(rs.getString("nombre"));
                p.setIdioma(rs.getString("idioma"));
                lista.add(p);
            }

            //Cerramos la conexion
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error al insertar pais: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void modificar(Pais p) {
        try {
            PreparedStatement st = c.conexion.prepareStatement("UPDATE INTO pais(nombre) VALUES ?");
            st.setString(1, p.getNombre());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar pais: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Pais p) {
        try {

            c.conectar();
            PreparedStatement st = c.conexion.prepareStatement("INSERT INTO pais(nombre) VALUES ?");
            st.setString(1, p.getNombre());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar pais: " + e.getMessage());
        }
    }

    public int obtenerId() {
        Pais p = ingresarDatos();
        try {

            c.conectar();

            int id;

            //Preparamos la consulta
            PreparedStatement st = c.conexion.prepareStatement("SELECT idpais FROM pais WHERE nombre = ?");
            st.setString(1, p.getNombre());

            //Ejecutamos la consulta
            ResultSet rs = st.executeQuery();


            // Verificamos si hay resultados antes de obtener el ID
            if (rs.next()) {
                id = rs.getInt("idpais"); // Obtenemos el ID del primer resultado
                p.setIdpais(id);
            } else {
                System.out.println("No se encontró el país en la base de datos.");
            }


            //Cierro la conexión//
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println("Hubo un error a realizar la consulta:" + e.getMessage());
        }
        return p.getIdpais();
    }


    public String obtenerPais(connectionDB c, int idpais) {
        String nombre = "";
        try {

            //Preparamos la consulta
            PreparedStatement st = c.conexion.prepareStatement("SELECT nombre FROM pais WHERE idpais = ?");
            st.setInt(1, idpais);

            //Ejecutamos la consulta
            ResultSet rs = st.executeQuery();

            // Verificamos si hay resultados antes de obtener el nombre
            if (rs.next()) {
                nombre = rs.getString("nombre"); // Obtenemos el nombre del primer resultado
            } else {
                System.out.println("No se encontró el país en la base de datos.");
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el nombre del pais con la idpais: " + e.getMessage());
        }
        return nombre;
    }
}
