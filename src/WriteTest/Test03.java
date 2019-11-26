package WriteTest;

import java.util.concurrent.locks.LockSupport;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin park");
                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("threadOne end unpark");
            }
        });
       threadOne.start();
       Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        threadOne.interrupt();
    }
}
