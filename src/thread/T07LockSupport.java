package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport会对
 */
public class T07LockSupport {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InnerClass());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
    private static class InnerClass implements Runnable{

        @Override
        public void run(){
            System.out.println("inner class begin locksupport park");
            LockSupport.park();
            System.out.println("inner class locksupport unpark");
        }
    }
}
