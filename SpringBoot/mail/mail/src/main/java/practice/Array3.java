package practice;

public class Array3 {
    public static void main(String[] args) {
        int[] arr = {1,4,20,3,10,5};
        int target = 33, sum = 0, start = 0;
        for (int end=0; end<arr.length; end++) {
            sum += arr[end];
            while (sum > target) sum -= arr[start++];
            if (sum == target) {
                System.out.println("Found between "+start+" and "+end);
                break;
            }
        }

    }
}
