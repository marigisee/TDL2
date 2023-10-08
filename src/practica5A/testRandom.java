package practica5A;

public class testRandom {

    /**
     * Vamos a verificar el correcto funcionamiento de la clase GeneraRandom() invocando 100 veces al método obtenerRandom()
     */
    public static void main(String[] args) {
        GeneraRandom generador = new GeneraRandom();
        for (int i = 0; i < 100; i++) {
            System.out.println("El numero random es: "+generador.obtenerRandom());
        }
    }
}
