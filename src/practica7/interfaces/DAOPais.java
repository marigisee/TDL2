package practica7.interfaces;
import  java.util.List;
import  practica7.model.Pais;
public interface DAOPais {

    public void insertarMientras();

    public Pais ingresarDatos();

    public void insertar(Pais p);

    public boolean verificarExistencia(String nombre);

    public List<Pais> listar();

    public void modificar(Pais p);

    public void eliminar(Pais p);

}
