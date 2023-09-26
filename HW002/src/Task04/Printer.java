package Task04;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;


class Calculator {
    public int calculate(char op, int a, int b) {
        // Напишите свое решение ниже
        String logPath = "log.txt";
        StringBuilder sb = new StringBuilder();

        int res = 0;
        switch (op) {

            case '+':
                res = a + b;
                break;

            case '-':
                res = a - b;
                break;

            case '/':
                res = a / b;
                break;

            case '*':
                res = a * b;
                break;

            default:
                System.out.println("Некорректный оператор: " + op);
                break;
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String data = now.format(formatter);

        sb.append(data).append(" User entered the first operand = ").append(a).append(System.lineSeparator());
        sb.append(data).append(" User entered the operation = ").append(op).append(System.lineSeparator());
        sb.append(data).append(" User entered the second operand = ").append(b).append(System.lineSeparator());
        sb.append(data).append(" Result is ").append(res).append(System.lineSeparator());
        sb.append("\n");
        String logLine = sb.toString();
        writeToFile(logLine, logPath);

        return res;
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
public class Printer {

    private static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        clearLogFile();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);

        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearLogFile() {
        File logFile = new File(LOG_FILE_PATH);
        if (logFile.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(logFile, false);
                fileWriter.write("");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
