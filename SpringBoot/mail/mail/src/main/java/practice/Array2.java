package practice;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        Array2 array2 = new Array2();
        array2.rotate(new int[]{1, 2, 3, 4, 5}, 2);
    }

    void rotate(int[] arr, int k) {
        k %= arr.length; // in case k > length
        reverse(arr, 0, arr.length - 1);   // reverse whole array
        reverse(arr, 0, k - 1);            // reverse first k elements
        reverse(arr, k, arr.length - 1);   // reverse remaining
        System.out.println(Arrays.toString(arr));
    }

    private int[] reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}
