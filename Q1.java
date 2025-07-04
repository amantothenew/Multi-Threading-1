// Q1)Create and Run a Thread using Runnable Interface and Thread class and show usage of sleep and join methods in the created threads.

public class Main {
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
    }
}


class MyClass extends Thread {
    public void run(){
        System.out.println("This is a thread using Thread class before sleep");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is a thread using Thread class after sleep");

    }
}

class MyThread implements Runnable{
    public void run(){
        System.out.println("This is a thread using Runnable interface before sleep");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("This is a thread using Runnable interface after sleep");
    }
}
