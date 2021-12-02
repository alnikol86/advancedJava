package main.java.ru.nikolaev.advancedjava.lambdaExpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lambdaTest1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");
        list.add("a");
        list.add("av");

        System.out.println(list);

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length() > o2.length()) {
//                    return 1;
//                } else if(o1.length() < o2.length()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });
        Comparator<String> comparator = (o1, o2) -> {
            if(o1.length() > o2.length()) return 1;
            else if(o1.length() < o2.length()) return -1;
            else return 0;
        };

        list.sort(comparator);

        System.out.println(list);
    }
}
