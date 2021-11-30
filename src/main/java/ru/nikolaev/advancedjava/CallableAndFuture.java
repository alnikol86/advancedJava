package main.java.ru.nikolaev.advancedjava;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() {
                System.out.println("Starting");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                return random.nextInt(10);
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);

        try {
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
