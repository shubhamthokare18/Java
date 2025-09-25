import java.util.TreeSet;
public class TreeSetString {
    public static void main(String[] args) {
        TreeSet<String> cars = new TreeSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        cars.add("Mazda");
        //cars.remove("Volvo");
        //cars.clear();
        //System.out.println("Size: " + cars.size());
        for(String i : cars) {
            System.out.println(i);
        }
    }
}