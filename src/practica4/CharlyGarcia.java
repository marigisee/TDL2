package practica4;

/**
 * Vamos a llevar a cabo un Patrón de Diseño Singleton para la clase CharlyGarcia.
 */
public class CharlyGarcia {

    //Variable estática que almacenará la única instancia de la clase
    private static CharlyGarcia instance = null;

    //Atributo privado de la clase
    private String nombreCompleto;

    //Constructor privado para evitar laa creacion de instancias
    //desde fuera de la clase
    private CharlyGarcia() {
        this.nombreCompleto = "Charly Alberto Garcia";
    }

    //Método estático que devuelve la instancia única de la clase
    public static CharlyGarcia getInstance() {
        if (instance == null) {
            instance = new CharlyGarcia();
        }
        return instance;
    }

    public void setNombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void cantar(){
        System.out.println("Charly Garcia está cantando");
    }
}
