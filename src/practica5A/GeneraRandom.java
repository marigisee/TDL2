package practica5A;
import java.lang.Math;
public class GeneraRandom {
    int MAXIMO_VALOR=2;

    public static void main(String[] args) {
        GeneraRandom gr = new GeneraRandom();
        System.out.println("El numero random es: "+gr.obtenerRandom());
    }

    public int obtenerRandom(){
        int numeroAleatorio = (int)(Math.random() * (MAXIMO_VALOR+1));
        return numeroAleatorio;
    }
}
