package main.java.ru.nikolaev.advancedjava.multithreading;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new MyThread());
        thread.start();

        System.out.println("Hello from main thread");
        Thread.sleep(3000);
        System.out.println("Bye from main thread");
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello from MyThread " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
