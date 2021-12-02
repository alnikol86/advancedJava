package main.java.ru.nikolaev.advancedjava.lambdaExpressions;

interface Executable {
    void execute();
}

class Runner {
    void run(Executable e) {
        e.execute();
    }
}

class ExecutableImplementation implements Executable {
    @Override
    public void execute() {
        System.out.println("Hello!1");
    }
}

public class lambdaTest1 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.run(new ExecutableImplementation());

        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("Hello!2");
            }
        });

        runner.run(() -> System.out.println("Hello!3"));
    }
}
