package thread;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Dead {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        DLcok l1 = new DLcok(o1, o2);
        new Thread(new DLcok(o1, o2)).start();
        new Thread(new DLcok(o2, o1)).start();
        System.out.println("main thread");
        System.out.println(Thread.currentThread().getId());
    }
    private static class DLcok implements Runnable{
        private Object first;
        private Object second;
        DLcok(Object o1, Object o2){
            this.first = o1;
            this.second = o2;
        }
        @Override
        public void run() {
            synchronized (first){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (second){
                    System.out.println("get sourceB");
                }
            }
        }
    }
}
