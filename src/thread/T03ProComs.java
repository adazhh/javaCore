package thread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

public class T03ProComs {
    final static T02DefinedThread lock = new T02DefinedThread();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();
    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 10;

    public static void main(String[] args){

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    // 队列满了则阻塞
                    while (queue.size() == queueSize) notEmpty.await();
                    // 添加元素到队列
                    queue.add("ele");
                    notFull.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (0 == queue.size()) notFull.await();
                    String ele = queue.poll();
                    notEmpty.signalAll();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}
