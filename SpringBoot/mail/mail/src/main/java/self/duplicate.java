package self;

import java.util.HashSet;
import java.util.Set;

public class duplicate {
    public static void main(String[] args) {
        int[] i={1,2,4,9,2,1};
        Set<Integer> unique=new HashSet<>();
        for(int x:i){
            if(!unique.add(x)){
                System.out.println("duplicate: " + x);
            }
        }
    }
}