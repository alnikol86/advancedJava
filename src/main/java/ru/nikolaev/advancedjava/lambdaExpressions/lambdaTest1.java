package main.java.ru.nikolaev.advancedjava.lambdaExpressions;

interface Executable {
    int execute(int x);
}

class Runner {
    void run(Executable e) {
        int i = e.execute(10);
        System.out.println(i);
    }
}

public class lambdaTest1 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.run(new Executable() {
            @Override
            public int execute(int x) {
                return x + 1;
            }
        });

        runner.run(x -> x + 2);
    }
}
