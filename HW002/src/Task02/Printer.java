package Task02;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        String logPath = "log.txt";
        StringBuilder sb = new StringBuilder();

        int count = mas.length;
        while (count != 0) {
            count = 0;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i+1]) {
                    int pock = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = pock;
                    count++;
                }
            }
            Date date = new Date();
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            sb.append(form.format(date)).append(" ").append(Arrays.toString(mas));
            sb.append("\n");
            String logLine = sb.toString();
            writeToFile(logLine, logPath);
        }
    }

    static void writeToFile(String line, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)){
            writer.write(line + System.lineSeparator());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка");
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) throws IOException {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
