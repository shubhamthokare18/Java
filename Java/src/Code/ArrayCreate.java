import java.util.Arrays;
import java.util.Scanner;

public class ArrayCreate {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Size of Array: ");
        int size = s.nextInt();
        int[] n = new int[size];
        for(int i=0; i<n.length; i++)
            n[i] = s.nextInt();
        System.out.println(Arrays.toString(n));
        for(int r:n)
        {
            System.out.println(r);
        }
    }
}