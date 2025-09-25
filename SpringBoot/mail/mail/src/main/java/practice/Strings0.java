package practice;

import java.util.Arrays;

public class Strings0 {
    public static void main(String[] args) {
        String s1="listen", s2="silent";
        char[] a=s1.toCharArray(), b=s2.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        System.out.println(Arrays.equals(a,b));

    }
}
