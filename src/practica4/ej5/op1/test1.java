package practica4.ej5.op1;

public class test1 {
    public static void main(String[] args) {
        /**
         * El sistema debe permitir ingresar información acerca de textos, Memoria Externa o Video
         * El sistema debe permitir listar información de todos los recursos y su detalle
         */
        // Creo la database
        Database db = new Database();

        // --- Creo los recursos ---
        Video video = new Video("The Matrix", "The Wachowskis", "English", 136);
        Textbook textbook = new Textbook("Java: How to Program", "Deitel & Deitel", "English", 1000);
        CD cd = new CD("When The Pawn...", "Fiona Apple", "English", 43);

        // -- Primera prueba: Ingresar los recursos a la database --
        db.addVideo(video);
        db.addTextbook(textbook);
        db.addCD(cd);

        // -- Segunda prueba: Listar información de todos los recursos y su detalle --
        db.list();

    }
}
