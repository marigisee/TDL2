package practica7.dao;
import practica7.interfaces.DAOPais;
import practica7.model.*;
import practica7.interfaces.DAOSede;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DAOSedeImpl implements DAOSede{

    private connectionDB c = new connectionDB();

    Scanner sc = new Scanner(System.in);

    public DAOSedeImpl(connectionDB c){
        this.c = c;
    }

    @Override
    public void insertarMientras() {

        Sede s = ingresarDatos();
        s = setPaisSede(c, s);
        boolean estaRepetido;
        //La inserción de los datos se realizará mientras el usuario no ingrese un signo de exclamación
        while (!s.getNombre().equals("!")) {
            s = setPaisSede(c,s);
            estaRepetido = verificarExistencia(s.getNombre(), s.getPais());
            if (estaRepetido) {
                System.out.println("La sede ingresada ya existe en la base de datos");
            } else {
                insertar(s);
            }
            s = ingresarDatos();
        }
    }


    @Override
    public boolean verificarExistencia(String nombre, String pais) {
        boolean existe = false;
        try {

            PreparedStatement st = c.conexion.prepareStatement("SELECT * FROM sede WHERE nombre = ? AND pais = ?");
            st.setString(1, nombre);
            st.setString(2, pais);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                existe = true;
            }

        }
        catch (Exception e){
            System.out.println("Error al verificar la existencia de la sede en la base de datos");
        }
        return false;
    }



    @Override
    public Sede ingresarDatos() {
        Sede s = new Sede();
        System.out.println("Ingresando datos sede...");
        System.out.println("Ingrese el nombre");
        s.setNombre(sc.nextLine());
        if (s.getNombre().equals("!")) {
            return s;
        } else {
            System.out.println("Ingrese la capacidad");
            s.setCapacidad(sc.nextInt());
            sc.nextLine();
        }
        return s;
    }

    @Override
    public Sede setPaisSede(connectionDB c, Sede s) {
        DAOPais daoPais = new DAOPaisImpl(c);
        System.out.println("Lista de paises disponibles:");
        List<Pais> listaPais = ((DAOPaisImpl) daoPais).listar();

        for (Pais p : listaPais) {
            System.out.println(p.toStringSinIdioma());
        }

        System.out.println("Elija el id del pais al que corresponde la sede");
        int id = sc.nextInt();
        sc.nextLine();

        s.setPais(((DAOPaisImpl) daoPais).obtenerPais(c,id));

        return s;
    }

    @Override
    public void insertar(Sede s) {
        System.out.println("Insertando sede");
        try {
            PreparedStatement st = c.conexion.prepareStatement("INSERT INTO sede(nombre, capacidad, pais) VALUES (?, ?, ?)");
            st.setString(1, s.getNombre());
            st.setInt(2, s.getCapacidad());
            st.setString(3, s.getPais());
            st.executeUpdate();
        }
        catch (Exception e){
            System.out.println("Error al insertar sede en la base de datos");
        }

    }

    public void modificar(Sede s){

    ;}

    public void eliminar(){
        System.out.println("Eliminando una sede");
        Sede s = ingresarDatos();
        try {
            PreparedStatement st = c.conexion.prepareStatement("DELETE FROM sede WHERE nombre = ? AND pais = ? AND capacidad = ?");
            st.setString(1, s.getNombre());
            st.setString(2, s.getPais());
            st.setInt(3, s.getCapacidad());
            st.executeUpdate();
            System.out.println("Sede eliminada");
        }
        catch (Exception e){
            System.out.println("Error al eliminar sede de la base de datos");
        }
    }

    public List<Sede> listar(){
        System.out.println("Listando sedes...");
        List<Sede> lista = null;
        try {
            PreparedStatement st = c.conexion.prepareStatement("SELECT * FROM sede");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Sede s = new Sede();
                s.setNombre(rs.getString("nombre"));
                s.setCapacidad(rs.getInt("capacidad"));
                s.setPais(rs.getString("pais"));
                lista.add(s);
            }
         }
        catch (Exception e){
            System.out.println("Error al listar sedes de la base de datos");
        }
        return lista;
    }

}
