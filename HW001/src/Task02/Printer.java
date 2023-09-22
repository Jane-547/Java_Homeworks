package Task02;

class Answer {
    static void printPrimeNums(){
        // Напишите свое решение ниже
        System.out.println("1");
        for (int i = 2; i < 1001; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i%j == 0) count++;
            }
            if (count < 2) System.out.println(i);
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {

        Answer ans = new Answer();
        ans.printPrimeNums();
    }
}
