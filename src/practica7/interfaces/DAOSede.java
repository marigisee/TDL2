package practica7.interfaces;
import practica7.model.Pais;
import  practica7.model.Sede;
import practica7.dao.connectionDB;

import java.util.List;

public interface DAOSede {
    public void insertarMientras();
    public Sede ingresarDatos();

    public void insertar(Sede s);
    public boolean verificarExistencia(String nombre, String pais);

    public Sede setPaisSede(connectionDB c, Sede s);

    public List<Sede> listar();


    public void modificar(Sede s);

    public void eliminar();

}
