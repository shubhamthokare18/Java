import java.util.HashSet;

public class CDHS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 3, 4};
        HashSet<Integer> seen = new HashSet<>();

        boolean foundDuplicate = false;

        for (int num : arr) {
            if (seen.contains(num)) {
                System.out.println("Duplicate found: " + num);
                foundDuplicate = true;
                break;
            }
            seen.add(num);
        }

        if (!foundDuplicate) {
            System.out.println("No duplicates found");
        }
    }
}
