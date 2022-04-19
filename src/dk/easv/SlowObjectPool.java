package dk.easv;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class SlowObjectPool {

    private Queue<SlowObject> reusables;
    private int size;
    private int counter;
    private static SlowObjectPool instance;

    private SlowObjectPool(int size) {
        reusables= new ArrayBlockingQueue<>(size);
    }
    public static SlowObjectPool getInstance(int size) {
        if (instance == null) {
            instance = new SlowObjectPool(size);
        }
        return instance;
    }


    public SlowObject acquire() throws InterruptedException {
        if (reusables.isEmpty() && counter < size) {
            SlowObject slowObject = new SlowObject();
            counter++;
            reusables.add(slowObject);
        }
        while (reusables.isEmpty()) {
            Thread.sleep(100);
        }
        return reusables.remove();
    }

    public void release(SlowObject slowObject) {
        reusables.add(slowObject);
    }

}



