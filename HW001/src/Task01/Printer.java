package Task01;

class Answer {
    static int countNTriangle(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }
}

class Printer {
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 5;
        } else {
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }
}
