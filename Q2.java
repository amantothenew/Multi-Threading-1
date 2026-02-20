// Q2)Use Synchronize method and synchronize block to enable synchronization between multiple threads trying to access method at same time.

public class Main {
    static int counter1 = 0;
    static int counter2 = 0;

    static Object lock = new Object();

    public static void main(String[] args) {
        MyClass t1 = new MyClass();
        Thread t2 = new Thread(new MyThread());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter with method sync: " + counter1);
        System.out.println("Counter with block sync: " + counter2);
    }

    static synchronized void incrementWithMethodSync() {
        counter1++;
    }

    static void incrementWithBlockSync() {
        synchronized (lock) {
            counter2++;
        }
    }
}

class MyClass extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Main.incrementWithMethodSync();
        }
    }
}

class MyThread implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Main.incrementWithBlockSync();
        }
    }
}
