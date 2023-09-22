class Calculator {
    static int calculate(char op, int a, int b) {
        // Введите свое решение ниже
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
        return res;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 11;
            op = ';';
            b = 5;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        int result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}