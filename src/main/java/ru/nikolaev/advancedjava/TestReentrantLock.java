package main.java.ru.nikolaev.advancedjava;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        task.print();
    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++)
            counter++;
    }

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void print() {
        System.out.println(counter);
    }
}
