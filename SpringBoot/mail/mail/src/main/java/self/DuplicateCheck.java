public class DuplicateCheck {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 2, 9, 4, 4};
        boolean foundDuplicate = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate found: " + arr[i]);
                    foundDuplicate = true;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicates found");
        }
    }
}
