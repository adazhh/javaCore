package thread;

import java.util.concurrent.locks.LockSupport;

public class T01threadLocal {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child begin park");
                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("child thread begin unpark");
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("interruptedException");
        }
        thread.interrupt();
        System.out.println("main thread end");
    }
}
