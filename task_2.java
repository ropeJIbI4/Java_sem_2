// Дана json строка (сохранить в файл и читать из файла) 
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова", "оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class task_2 {
    private static JSONObject object1 = new JSONObject();

    public static void writeJson(String fileName) {
        JSONArray messages = new JSONArray();

        object1.put("фамилия", "Иванов");
        object1.put("оценка", "5");
        object1.put("предмет", "Математика");
        messages.add(object1);

        JSONObject object2 = new JSONObject();
        object2.put("фамилия", "Петрова");
        object2.put("оценка", "4");
        object2.put("предмет", "Информатика");
        messages.add(object2);

        JSONObject object3 = new JSONObject();
        object3.put("фамилия", "Краснов");
        object3.put("оценка", "5");
        object3.put("предмет", "Физика");
        messages.add(object3);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(messages.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error");
        }

    }

    public static void readJson(String fileName) throws ParseException, org.json.simple.parser.ParseException {

        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader(fileName));
            for (Object o : a) {
                JSONObject employee = (JSONObject) o;
                StringBuilder sb = new StringBuilder();
                String name = (String) employee.get("фамилия");
                sb.append("Студент ").append(name);
                String note = (String) employee.get("оценка");
                sb.append(" получил ").append(note);                
                String item = (String) employee.get("предмет");
                sb.append(" по предмету ").append(item);

                System.out.println(sb);
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String pathProject = System.getProperty("user.dir");
        String pathFail = pathProject.concat("/SEM 2/task_2.json");
        writeJson(pathFail);
        readJson(pathFail);
    }

}
