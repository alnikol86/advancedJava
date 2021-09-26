package main.java.ru.nikolaev.advancedjava;

import java.util.Scanner;

public class KeyVolatile {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread1.shutdown();
    }
}

class MyThread1 extends Thread {
    private volatile boolean running = true;
    private int i = 0;

    public void run() {
        while(running) {
            System.out.println("Hello " + i++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}