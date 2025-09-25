import java.util.Arrays;
public class ReverseArray {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4};
        for (int i=0; i<a.length/2; i++){
            int t = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = t;
        }
        System.out.println("Reverse array: " + Arrays.toString(a));
    }
}