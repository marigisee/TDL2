package practica5B.math;
import java.util.Scanner;
public class TestNumeroComplejo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Introduzca la parte real del primer numero complejo: ");
        double re = in.nextDouble();
        System.out.println("Introduzca la parte imaginaria del primer numero complejo: ");
        double im = in.nextDouble();
        NumeroComplejo c1 = new NumeroComplejo(re,im);


        System.out.println("Introduzca la parte real del segundo numero complejo: ");
        re = in.nextDouble();
        System.out.println("Introduzca la parte imaginaria del segundo numero complejo: ");
        im = in.nextDouble();
        NumeroComplejo c2 = new NumeroComplejo(re,im);

        System.out.println("La suma del numero complejo "+c1+ " y el numero complejo "+c2+" es: "+c1.add(c2));
        System.out.println("La resta del numero complejo "+c1+ " y el numero complejo "+c2+" es: "+c1.substract(c2));

    }
}
