package thread;

import com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class T00lock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        String ada = new String("ada");

        List<Integer> list = new ArrayList<>();
    }

}
