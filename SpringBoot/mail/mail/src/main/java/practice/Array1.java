package practice;

import java.util.HashSet;
import java.util.Set;

public class Array1 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,3,4,1};
        Set<Integer> seen = new HashSet<>();
        for (int x : arr) {
            if (!seen.add(x)) System.out.println("Duplicate: " + x);
        }

    }
}
