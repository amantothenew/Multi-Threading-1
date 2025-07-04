// Q4)Write a code to simulate a deadlock in java

public class Main {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new FirstTask());
        Thread t2 = new Thread(new SecondTask());

        t1.start();
        t2.start();
    }
}


class FirstTask implements Runnable {
    public void run() {
        synchronized (Main.lock1) {
            System.out.println("Thread 1: locked resource 1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1: trying to lock resource 2...");
            synchronized (Main.lock2) {
                System.out.println("Thread 1: locked resource 2");
            }
        }
    }
}

class SecondTask implements Runnable {
    public void run() {
        synchronized (Main.lock1) {
            System.out.println("Thread 2: locked resource 2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 2: trying to lock resource 1...");
            synchronized (Main.lock2) {
                System.out.println("Thread 2: locked resource 1");
            }
        }
    }
}
