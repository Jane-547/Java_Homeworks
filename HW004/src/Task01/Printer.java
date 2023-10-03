package Task01;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class LLTasks {
    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        // Напишите свое решение ниже
        LinkedList<Object> res = new LinkedList<>();
        ListIterator<Object> it = ll.listIterator();
        for (Object i : ll) {
            res.add(0, i);
        }
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        LinkedList<Object> ll = new LinkedList<>();

        if (args.length == 0 || args.length != 4) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            ll.add(1);
            ll.add("One");
            ll.add(2);
            ll.add("Two");
        } else {
            ll.add(Integer.parseInt(args[0]));
            ll.add(args[1]);
            ll.add(Integer.parseInt(args[2]));
            ll.add(args[3]);
        }

        LLTasks answer = new LLTasks();
        System.out.println(ll);
        LinkedList<Object> reversedList = answer.revert(ll);
        System.out.println(reversedList);
    }
}

