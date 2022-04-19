package dk.easv;

public class Main {

    public static void main(String[] args) {
        SlowObjectPool pool =SlowObjectPool.getInstance(5);
        try {
            SlowObject slowObject1 = pool.acquire();
            SlowObject slowObject2 = pool.acquire();
            SlowObject slowObject3 = pool.acquire();
            SlowObject slowObject4 = pool.acquire();
            SlowObject slowObject5 = pool.acquire();
            SlowObject slowObject6 = pool.acquire();
            pool.release(slowObject1);
            pool.release(slowObject2);
            pool.release(slowObject3);
            pool.release(slowObject4);
            pool.release(slowObject5);
            pool.release(slowObject6);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
