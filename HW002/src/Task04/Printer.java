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

        StringBuilder log = new StringBuilder();
        log.append(logi(" User entered the first operand = ", Integer.toString(a)));
        log.append(logi(" User entered the operation = ", Character.toString(op)));
        log.append(logi(" User entered the second operand = ", Integer.toString(b)));
        log.append(logi(" Result is ", Integer.toString(res)));
        String mess = log.toString();

        writeToFile(mess, logPath);

        return res;
    }

    static void writeToFile(String line, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(line + System.lineSeparator());
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка");
        }
    }
    static String logi(String note, String value) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        StringBuilder sb = new StringBuilder(now.format(formatter) + note + value + System.lineSeparator());
        return sb.toString();
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
