import java.sql.SQLOutput;
import java.util.ArrayList;
public class NameFilter {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Ankit");
        names.add("Charlie");
        names.add("Amit");
        names.add("David");
        System.out.println("Names starting with 'A':");
        for (String name : names) {
            if (name.startsWith("A")) {
                System.out.println(name);
            }
        }
    }
}