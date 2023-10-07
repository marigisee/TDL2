package practica4.unlp.info.comparacionstring;

public class StringDemo {
    public static void main(String[] args) {

        String str1="Leones y Tigres y Osos!";
        String str2="Leones y Tigres y Osos!";
        String str3=str2;
        String str4=new String("Leones y Tigres y Osos!");
        String str5=" Y yo!";
        String str6="Leones y Tigres y Osos! Y yo!";
        String str7= str1 + str5;

        //Tanto str1 como str2 estan referenciando a la misma direccion de memoria debido a que
        //ambas son inicializadas con el mismo valor y por lo tanto dicho valor se
        //encuentra en la String Pool.

        System.out.println(str1==str2); //true
        System.out.println(str1==str3); //true

        //Como str4 fue inicalizada de diferente manera (con el operador new) se almacena en la heap memory
        //y por lo tanto no se encuentra en la String Pool (y no referencia asi a la misma direccion de memoria).

        System.out.println(str1==str4); //false

        //Ambas referencian al mismo espacio de memoria por como estan inicializadas
        System.out.println(str2==str3); //true

        //str4 esta inicializado de tal manera que se reservo espacio en la heap memory y no esta utilizando
        //la String Pool, por lo tanto no referencia a la misma direccion de memoria que str1, str2 y str3.
        System.out.println(str2==str4); //false
        System.out.println(str3==str4); //false

        //str6 y str7 estan inicializadas de diferente manera, por lo tanto no se encuentran en la String Pool.
        System.out.println(str6==str7); //false

        //str1 y str4 tienen el mismo valor, por lo tanto son iguales.
        System.out.println(str1.equals(str4)); //true
        System.out.println(str6.equals(str7)); //true
    }
}