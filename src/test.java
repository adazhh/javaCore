import java.util.*;

public class test {
    public static void main(String[] args) {
        // Singleton singleton = Singleton.getInstance();
        Singleton.Order();
        System.out.println("---------------");
        System.out.println(Singleton.numA);
        System.out.println(Singleton.numB);
    }
}
class Singleton{
    public static int numA = 10;
    public static Singleton singleton = new Singleton();

    static {
        System.out.println("first");
    }
    private Singleton(){
        System.out.println("Construct method");
        System.out.println("construct numA and numB:" + numA + numB);
        numA++;
        numB++;
        System.out.println("numA: " + numA);
        System.out.println("numB: " + numB);
    }
    static {
        System.out.println("before numB");
    }
    public static int numB = 8;
    public static Singleton getInstance(){
        System.out.println("getInstance method");
        System.out.println("getInstance numB: " + numB);
        System.out.println("getInstance numB: " + numA);
        return singleton;
    }

    public static void Order(){
        System.out.println("Order numB: " + numB);
        numB = 323;
        System.out.println("Order numB: " + numB);
    }
    static {
        System.out.println("last");
        System.out.println("last: " + numB);
        numB = 50;
    }
}
