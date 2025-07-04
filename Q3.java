// Q3)WAP to showcase the usage of volatile in java.

public class Main {
    static volatile boolean running = true;

    public static void main(String[] args) {
        MyClass t1 = new MyClass();
        t1.start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread stopping worker thread...");
        running = false;
    }
}

class MyClass extends Thread {
    public void run() {
        System.out.println("Worker thread started...");
        while (Main.running) {
            System.out.println("Loop is Running");
        }
        System.out.println("Worker thread stopped...");
    }
}
