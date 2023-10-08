package practica5A.griego;
import practica5A.griego.Alpha3;
public class DeltaBis extends Alpha3 {

    public static void main(String[] args) {
        DeltaBis d = new DeltaBis();
        Alpha3 a = new Alpha3();
        d.unMetodoD(a, d);
    }
    void unMetodoD(Alpha3 a, DeltaBis d){
        a.x=10;
        d.x=10;
        a.otroMetodoA();
        d.otroMetodoA();
    }
}