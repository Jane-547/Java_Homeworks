import java.util.*;


public class Main {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в магазин ноутбуков!");

        Map <Integer, Integer> memories = new HashMap<>();
        Map <Integer, Integer> hdds = new HashMap<>();
        Map <Integer, String> oss = new HashMap<>();
        Map <Integer, String> colours = new HashMap <>();

        Notebook.fillMemories(memories);
        Notebook.fillHdds(hdds);
        Notebook.fillOss(oss);
        Notebook.fillColours(colours);

        Set <Notebook> allNotebooks = new HashSet<>();
        for (int i = 0; i <= 10; i++) {
            Notebook element = Notebook.generateNotebook(memories, hdds, oss, colours);
            System.out.println(element);
            allNotebooks.add(element);
        }


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