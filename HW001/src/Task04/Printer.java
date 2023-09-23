package Task04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Equation {
    static String getSolution(String str) {
        // Введите свое решение ниже
        System.out.println("Given the equation: " + str);
        String[] parts = str.split("\s*[+=]\s*");
        int q = 0, w = 0, e = 0;
        String res = "No solution";

        for (int i = 0; i < 10; i++) {
            if (parts[0].contains("?")) {
                char pos = Integer.toString(i).charAt(0);
                String first = parts[0].replace('?', pos);
                q = Integer.parseInt(first);
            } else q = Integer.parseInt(parts[0]);
            //System.out.println(q);
            for (int j = 0; j < 10; j++) {
                if (parts[1].contains("?")) {
                    char pos1 = Integer.toString(j).charAt(0);
                    String second = parts[1].replace('?', pos1);
                    w = Integer.parseInt(second);
                } else w = Integer.parseInt(parts[1]);
                //System.out.println(w);
                for (int k = 0; k < 10; k++) {
                    if (parts[2].contains("?")) {
                        char pos2 = Integer.toString(k).charAt(0);
                        String third = parts[2].replace('?', pos2);
                        e = Integer.parseInt(third);
                    } else e = Integer.parseInt(parts[2]);
                    if (q + w == e) res = "Result: " + q + " + " + w + " = " + e;
                }
            }
        }
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
        class Printer {
            public static void main(String[] args) {
                String file = "";

                if (args.length == 0) {
                    file = "2? + ?5 = 69";
                } else {
                    file = args[0];
                }

                Equation eq = new Equation();
                String result = eq.getSolution(file);
                System.out.println(result);
            }
        }
