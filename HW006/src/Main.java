import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в магазин ноутбуков!");

        Map <Integer, Integer> memories = new HashMap<>();
        Notebook.fillMemories(memories);
        Map <Integer, Integer> hdds = new HashMap<>();
        Notebook.fillHdds(hdds);
        Map <Integer, String> oss = new HashMap<>();
        Notebook.fillOss(oss);
        Map <Integer, String> colours = new HashMap <>();
        Notebook.fillColours(colours);

        Set <Notebook> allNotebooks = new HashSet<>();
        for ()
        Notebook element = Notebook.generateNotebook(memories, hdds, oss, colours);
        System.out.println(element);

        int d = 0;
        while (d == 0) {
            System.out.println("Выберите параметры: ");
            System.out.println("1 - объем оперативной памяти,");
            System.out.println("2 - объем жесткого диска,");
            System.out.println("3 - операционная система,");
            System.out.println("4 - цвет.");
            System.out.println("Если Вы выбрали все параметры, нажмите 5");

            Scanner sc = new Scanner(System.in);
            int point = 0;
            try {
                point = Integer.parseInt(sc.nextLine());
                switch (point) {
                    case 1:
                        System.out.println(memories);
                        System.out.println(hdds);
                        System.out.println(oss);
                        System.out.println(colours);
                        break;

                    case 2:
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        d = 1;
                        sc.close();
                        break;

                    default:
                        System.out.println("Вы ввели неверное значение. Попробуйте еще раз)");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Вы ввели не число.");
            }
        }
    }
}