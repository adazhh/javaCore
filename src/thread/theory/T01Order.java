package thread.theory;

public class T01Order {
    private static int count = 0;
    private static void add(){
        int i = 0;
        while (i++ <= 10000){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            add();
        });
        Thread th2 = new Thread(() -> {
            add();
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(count);
    }
}
