package main.java.ru.nikolaev.advancedjava.lambdaExpressions;

interface Executable {
    int execute(int x, int y);
}

class Runner {
    void run(Executable e) {
        int i = e.execute(10, 5);
        System.out.println(i);
    }
}

public class lambdaTest1 {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.run(new Executable() {
            @Override
            public int execute(int x, int y) {
                return x + 1 - y;
            }
        });

        int a = 10;
        runner.run((x, y) -> x + 2 - y + a);
    }
}
