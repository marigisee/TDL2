package practica4;

public class TestCharly {
    public static void main(String[] args) {
        CharlyGarcia charly = CharlyGarcia.getInstance();
        charly.cantar();
        charly.setNombre("Charlito Garcia");
        System.out.println("El nombre completo de Charly es: " + charly.getNombreCompleto());
        CharlyGarcia charly2 = CharlyGarcia.getInstance();
        System.out.println("El nombre completo de Charly es: " + charly2.getNombreCompleto());
    }
}
