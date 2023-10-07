package practica4.ej5.op2;
/******************************************
 * This subclass of the class Item represents a multimedia item.
 ******************************************/
public class MultiMediaItem extends Item {
    private int playingTime;
    public MultiMediaItem(String title, String language, int time) {
        super(title, language);
        playingTime = time;
    }
    public void print() {
        super.print();
        System.out.println("Playing Time: " + playingTime + "mins");
    }
}
