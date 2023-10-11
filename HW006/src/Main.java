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
        for (int i = 1; i <= 5; i++) {
            Notebook element = Notebook.generateNotebook(memories, hdds, oss, colours);
            System.out.println(element);
            allNotebooks.add(element);
        }

        int minMemory = 1;
        int minHdd = 1;
        String userOs = "0";
        String userColour = "0";

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
                        System.out.println("Выберите минимальный объем оперативной памяти:");
                        System.out.println("1 - 8Gb");
                        System.out.println("2 - 16Gb");
                        System.out.println("3 - 32Gb");
                        String userMemory = sc.nextLine();
                        try {
                            minMemory = Integer.parseInt(userMemory);
                            if (minMemory < 1 || minMemory > 3) {
                                minMemory = 1;
                                System.out.println("Неверное значение.");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Вы ввели не число.");
                        }
                        break;

                    case 2:
                        System.out.println("Выберите минимальный объем жесткого диска:");
                        System.out.println("1 - 512Gb");
                        System.out.println("2 - 1024Gb");
                        String userHdd = sc.nextLine();
                        try {
                            minHdd = Integer.parseInt(userHdd);
                            if (minHdd < 1 || minHdd > 3) {
                                minHdd = 1;
                                System.out.println("Неверное значение.");
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Вы ввели не число.");
                        }
                        break;

                    case 3:
                        System.out.println("Выберите операционную систему");
                        System.out.println("1 - Windows 11");
                        System.out.println("2 - FreeDos");
                        System.out.println("3 - без операционной системы");
                        int choiceOs = sc.nextInt();
                        userOs = oss.get(choiceOs);
                        break;

                    case 4:
                        System.out.println("Выберите цвет");
                        System.out.println("1 - black");
                        System.out.println("2 - silver");
                        System.out.println("3 - white");
                        int choiceColour = sc.nextInt();
                        userColour = colours.get(choiceColour);
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

        for (Notebook book : allNotebooks) {
            if (memories.get(minMemory) <= book.memory && hdds.get(minHdd) <= book.hdd && (userOs.equals("0") || book.os.equals(userOs)) && (userColour.equals("0") || book.colour.equals(userColour))){
                System.out.println(book);
            }
        }
    }
}