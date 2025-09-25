public class CheckDuplicates {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 0, 1};
        boolean foundDuplicate = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    System.out.println("Duplicate found: " + a[i]);
                    foundDuplicate = true;
                }
                }
            }
        if (!foundDuplicate) {
            System.out.println("No duplicate found");
    }
}
}