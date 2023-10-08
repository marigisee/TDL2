package practica5A.romano;
import practica5A.griego.Alpha3;
public class Delta extends Alpha3 {

    public static void main(String[] args) {
        Delta d = new Delta();
        Alpha3 a = new Alpha3();
        d.unMetodoD(a, d);
    }
    void unMetodoD(Alpha3 a, Delta d){
        //a.x=10;
        d.x=10;
        //a.otroMetodoA();
        d.otroMetodoA();
    }
}