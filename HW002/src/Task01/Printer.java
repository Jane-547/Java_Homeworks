package Task01;

import java.util.HashMap;
import java.util.Map;

class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS) {
        // Напишите свое решение ниже
        StringBuilder res = new StringBuilder();
        String task = PARAMS;
        String[] parts = task.split(",");
        HashMap<String, String> fromJson = new HashMap<>();

        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replace("\"", "");
            parts[i] = parts[i].replace("{", "");
            parts[i] = parts[i].replace("}", "");
            String[] subparts = parts[i].split(":");
            fromJson.put(subparts[0], subparts[1]);
        }
        System.out.println(fromJson);

        String [] zapros = QUERY.split(" ");

        switch (zapros[1]){

            case "*":
                for (Map.Entry<String, String> entry : fromJson.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    if (value != null && !value.contains("null")){
                        res.append(key).append(" = ").append(value).append(" AND ");
                    }
                }
                res.setLength(res.length() - 5);
                break;

            case "name":
                for (Map.Entry<String, String> entry : fromJson.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    if (value != null && !value.contains("null") && key.contains("name")){
                        res.append(key).append(" = ").append(value).append(" AND ");
                    }
                }
                res.setLength(res.length() - 5);
                break;

            case "country":
                for (Map.Entry<String, String> entry : fromJson.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    if (value != null && !value.contains("null") && key.contains("country")){
                        res.append(key).append(" = ").append(value).append(" AND ");
                    }
                }
                res.setLength(res.length() - 5);
                break;


            case "city":
                for (Map.Entry<String, String> entry : fromJson.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    if (value != null && !value.contains("null") && key.contains("city")){
                        res.append(key).append(" = ").append(value).append(" AND ");
                    }
                }
                res.setLength(res.length() - 5);
                break;

            default:
                System.out.println("Wrong parameter");
                break;
        }
        //res.setLength(res.length() - 5);
        return res;
    }
}


    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public class Printer {
        public static void main(String[] args) {
            String QUERY = "";
            String PARAMS = "";

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                QUERY = "select * from students where ";
                PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
            } else {
                QUERY = args[0];
                PARAMS = args[1];
            }

            Answer ans = new Answer();
            System.out.println(ans.answer(QUERY, PARAMS));
        }
    }
