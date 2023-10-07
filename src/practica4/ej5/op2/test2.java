package practica4.ej5.op2;
import  practica4.ej5.op2.Database;
import practica4.ej5.op2.CD;
import practica4.ej5.op2.Textbook;
import practica4.ej5.op2.Video;

public class test2 {
    public static void main(String[] args) {
        /**
         * El sistema debe permitir ingresar información acerca de textos, Memoria Externa o Video
         * El sistema debe permitir listar información de todos los recursos y su detalle
         */
        // Creo la database
        Database db = new Database();

        // -- Creo los recursos  -- //
        Item video = new Video("The Matrix", "The Wachowskis", "English", 136);
        Item textbook = new Textbook("Java: How to Program", "Deitel & Deitel", "English", 1000);
        Item cd = new CD("When The Pawn...", "Fiona Apple", "English", 43);

        // -- Primera prueba: Ingresar los recursos a la database -- //
        db.addItem(video);
        db.addItem(textbook);
        db.addItem(cd);

        // -- Segunda prueba: Listar información de todos los recursos y su detalle -- //
        db.list();
    }
}
