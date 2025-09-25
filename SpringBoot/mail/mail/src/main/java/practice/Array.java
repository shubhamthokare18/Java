package practice;

public class Array {
    public static void main(String[] args) {
        int[] arr = {5, 9, 2, 11, 7};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("Second Largest: " + second);

    }
}
