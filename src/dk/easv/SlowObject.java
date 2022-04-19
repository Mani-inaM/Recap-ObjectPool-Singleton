package dk.easv;

import java.util.AbstractMap;

public class SlowObject {

    public SlowObject() {
        try {
            Thread.sleep(500);
            System.out.println("SlowObject created");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
