package main.java.ru.nikolaev.advancedjava.lambdaExpressions;

interface Executable {
    int execute();
}

class Runner {
    void run(Executable e) {
        int i = e.execute();
        System.out.println(i);
    }
}

public class lambdaTest1 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.run(new Executable() {
            @Override
            public int execute() {
                System.out.println("Hello!1");
                System.out.println("Goodbye!1");

                return 1;
            }
        });

        runner.run(() -> {
            System.out.println("Hello!2");
            System.out.println("Goodbye!2");

            return 2;
        });
    }
}
