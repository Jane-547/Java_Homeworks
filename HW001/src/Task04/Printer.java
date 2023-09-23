package Task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

            for (int j = 0; j < 10; j++) {
                if (parts[1].contains("?")) {
                    char pos1 = Integer.toString(j).charAt(0);
                    String second = parts[1].replace('?', pos1);
                    w = Integer.parseInt(second);
                } else w = Integer.parseInt(parts[1]);

                int count = 0;

                for (int k = 0; k < 10; k++) {
                    if (parts[2].contains("?")) {
                        char pos2 = Integer.toString(k).charAt(0);
                        String third = parts[2].replace('?', pos2);
                        e = Integer.parseInt(third);
                    } else {
                        e = Integer.parseInt(parts[2]);
                        count++;
                    }
                    if (q + w == e && count < 2) {
                        res = "Result: " + q + " + " + w + " = " + e;
                        System.out.println(res);
                    }
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

                try {
                    Scanner sc = new Scanner(new File("C:\\Всякое мое\\Учеба Гик\\5. Java\\Java_Homeworks\\HW001\\src\\Task04\\input.txt"));
                    while (sc.hasNextLine()) {
                        file = sc.nextLine();
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                String file = "";
//
//                if (args.length == 0) {
//                    file = "input.txt";
//                } else {
//                    file = args[0];
//                }

                Equation eq = new Equation();
                String result = eq.getSolution(file);
                //System.out.println(result);
            }
        }
