package practica7.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import practica7.interfaces.DAOFutbolista;
import practica7.interfaces.DAOPais;
import practica7.model.Futbolista;
import practica7.model.Pais;

public class DAOFutbolistaImpl implements DAOFutbolista {

    private connectionDB c = new connectionDB();


    Scanner sc = new Scanner(System.in);

    public DAOFutbolistaImpl(connectionDB c) {
        this.c = c;
    }


    public void insertarMientras() {
        Futbolista f = ingresarDatos();
        boolean estaRepetido;
        //La inserción de los datos se realizará mientras el usuario no ingrese un signo de exclamación
        while (!f.getNombre().equals("!")) {
            estaRepetido = verificarExistencia(f.getNombre(), f.getApellido());
            if (estaRepetido) {
                System.out.println("El jugador ya existe");
            } else {
                f = setPaisFutbolista(c, f);
                insertar(f);
            }
            f = ingresarDatos();
        }
    }

    public Futbolista ingresarDatos() {
        Futbolista f = new Futbolista();
        System.out.println("Ingresando datos futbolista...");
        System.out.println("Ingrese el nombre");
        f.setNombre(sc.nextLine());
        if (f.getNombre().equals("!")) {
            return f;
        } else {


            System.out.println("Ingrese el apellido");
            f.setApellido(sc.nextLine());
            System.out.println("Ingrese el documento de identidad");
            f.setDocIdentidad(sc.nextLine());
            System.out.println("Ingrese el telefono");
            f.setTelefono(sc.nextLine());
            System.out.println("Ingrese el email");
            f.setEmail(sc.nextLine());

        }
        return f;

    }

    public boolean verificarExistencia(String nombre, String apellido) {
        boolean existe = false;
        try {

            PreparedStatement st = c.conexion.prepareStatement("SELECT * FROM futbolista WHERE nombre = ? AND apellido = ?");
            st.setString(1, nombre);
            st.setString(2, apellido);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                existe = true;
            }

        } catch (Exception e) {
            System.out.println("Error al verificar existencia: " + e.getMessage());
        } finally {

        }
        return existe;
    }

    public Futbolista setPaisFutbolista(connectionDB c, Futbolista f) {

        try {

            DAOPais daoPais = new DAOPaisImpl(c);

            System.out.println("Lista de paises disponibles para representar:");

            List<Pais> listaPais = daoPais.listar();

            for (Pais p : listaPais) {
                System.out.println(p.toStringSinIdioma());
            }

            System.out.println("Elija el id del pais que desea representar");
            int id = sc.nextInt();
            sc.nextLine();
            f.setIdpais(id);

        } catch (Exception e) {
            System.out.println("Error al insertar futbolista: " + e.getMessage());
        }

        return f;
    }


    public void insertar(Futbolista f) {

        System.out.println("Insertando futbolista");

        try {


            boolean condicion = true;
            DAOPais daoPais = new DAOPaisImpl(c);
            System.out.println("Los datos a ingresar son:");
            System.out.println(f.toString());

            do {
                System.out.println("¿Desea ingresar dicho futbolista?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingresando futbolista a la base da datos...");
                        PreparedStatement st = c.conexion.prepareStatement("INSERT INTO futbolista(nombre, apellido, docIdentidad, telefono, email, idpais) VALUES (?, ?, ?, ?, ?, ?)");
                        st.setString(1, f.getNombre());
                        st.setString(2, f.getApellido());
                        st.setString(3, f.getDocIdentidad());
                        st.setString(4, f.getTelefono());
                        st.setString(5, f.getEmail());
                        st.setInt(6, f.getIdpais());

                        st.executeUpdate();
                        condicion=false;
                        break;

                    case 2:
                        System.out.println("Cancelando inserción de futbolista...");
                        condicion = false;
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }

            } while (condicion);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<Futbolista> listar() {
        List<Futbolista> lista = null;
        try {

            //Preparamos la consulta
            PreparedStatement st = c.conexion.prepareStatement("SELECT * FROM futbolista");
            ResultSet rs = st.executeQuery();

            lista = new ArrayList<>();

            //Recorremos el resultado, mientras haya registros para leer, y llenamos la lista
            while (rs.next()) {
                Futbolista f = new Futbolista();
                f.setIdpais(rs.getInt("idfutbolista"));
                f.setNombre(rs.getString("nombre"));
                f.setApellido(rs.getString("apellido"));
                f.setDocIdentidad(rs.getString("docIdentidad"));
                f.setTelefono(rs.getString("telefono"));
                f.setEmail(rs.getString("email"));
                f.setIdpais(rs.getInt("idpais"));
                lista.add(f);
            }

            //Cerramos la conexion
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println("Error al insertar futbolista: " + e.getMessage());
        }
        return lista;
    }



}