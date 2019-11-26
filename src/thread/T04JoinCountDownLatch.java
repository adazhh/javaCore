package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T04JoinCountDownLatch {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
                System.out.println("child thread1 is over");
            }
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("child thread2 is over");
        });
        System.out.println("wait all child thread over");
        countDownLatch.await();
        System.out.println("all child thread is over");
        executorService.shutdown();
    }
}
