package WriteTest;

import java.util.concurrent.locks.LockSupport;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        Sup sup = new Sub();
        System.out.println(sup.i);
        Sub sub = (Sub) sup;
        sub.word();
        sub.show();
    }
    public void tt(){
    }

}
class Sup{
    public int i = 1;
    public Sup(){
        show();
    }
    public void show(){
        System.out.println("sup class");
    }
    private void tttt(){
        System.out.println("jj");
    }
}
class Sub extends Sup {
    public int i = 2;

    public void word() {
        System.out.println("word");
    }
    private void tttt() {
        System.out.println("hhh");
    }
}

