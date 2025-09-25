package practice;

import java.util.Arrays;
import java.util.Collections;

public class Strings {
    public static void main(String[] args) {
        String s = "I love Java";
        String[] parts = s.split(" ");
        Collections.reverse(Arrays.asList(parts));
        System.out.println(String.join(" ", parts));
    }
}
