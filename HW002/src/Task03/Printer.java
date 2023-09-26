package Task03;

class Answer {
    public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {
        // Напишите свое решение ниже
        StringBuilder res = new StringBuilder();
        String task = JSON;
        String[] parts = task.split(",");

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("\"", "");
            parts[i] = parts[i].replace("{", "");
            parts[i] = parts[i].replace("}", "");
            parts[i] = parts[i].replace(" ", "");
            parts[i] = parts[i].replace("[", "");
            parts[i] = parts[i].replace("]", "");
            parts[i] = parts[i].replace("фамилия:", ELEMENT1);
            parts[i] = parts[i].replace("оценка:", ELEMENT2);
            parts[i] = parts[i].replace("предмет:", ELEMENT3);
        }

        for (int i=0; i < parts.length; i++) {
            if (parts[i].contains(ELEMENT3)) res.append(parts[i] + System.lineSeparator());
            else res.append(parts[i]);
        }
        System.out.println(res.toString());
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        String JSON = "";
        String ELEMENT1 = "";
        String ELEMENT2 = "";
        String ELEMENT3 = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
            ELEMENT1 = "Студент ";
            ELEMENT2 = " получил ";
            ELEMENT3 = " по предмету ";
        }
        else{
            JSON = args[0];
            ELEMENT1 = args[1];
            ELEMENT2 = args[2];
            ELEMENT3 = args[3];
        }

        Answer ans = new Answer();
        ans.answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3);
    }
}
