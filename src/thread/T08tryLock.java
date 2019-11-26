package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class T08tryLock {
    private static Lock lock = new ReentrantLock();
    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new InnerClass1());
        Thread th2 = new Thread(new InnerClass2());
        th1.start();
        Thread.sleep(2);
        th2.start();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(th1);
    }

    static class InnerClass1 implements Runnable{
        @Override
        public void run(){
            lock.lock();
            System.out.println(Thread.currentThread().getId() + "get lock");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println(Thread.currentThread().getId() + "unlock lock");
        }
    }
    static class InnerClass2 implements Runnable{
        @Override
        public void run() {
            lock.tryLock();
            System.out.println(Thread.currentThread().getId() + "get lock");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getId() + "out lock");
        }
    }
}
