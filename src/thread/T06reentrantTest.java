package thread;

import java.util.concurrent.locks.ReentrantLock;

public class T06reentrantTest implements Runnable {

    public static void main(String[] args) {
        T06reentrantTest test = new T06reentrantTest();
        Thread thread = new Thread(test);
        Thread thread1 = new Thread(test);
        thread.start();
        thread1.start();
    }
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();

        System.out.println("get method start");
        System.out.println(Thread.currentThread().getId() + "call set method");
        set();
        lock.unlock();
    }

    private void set() {
        lock.lock();
        System.out.println("set method start");
        System.out.println(Thread.currentThread().getId() + "set method");
        lock.unlock();
    }


}
