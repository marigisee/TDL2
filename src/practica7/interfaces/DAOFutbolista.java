package practica7.interfaces;

import practica7.model.Futbolista;
import practica7.dao.connectionDB;
import java.util.List;

public interface DAOFutbolista {

     public void insertarMientras();
     public Futbolista ingresarDatos();
     public void insertar(Futbolista f);

     public boolean verificarExistencia(String nombre, String apellido);

     public List<Futbolista> listar();

     public Futbolista setPaisFutbolista(connectionDB c, Futbolista f);

}
