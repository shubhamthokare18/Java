import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("Alice", "Jhon", "Charlie");
        names.forEach(System.out::println);
    }
}
