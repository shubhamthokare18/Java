import java.util.HashMap;

public class SquareCache {
    private HashMap<Integer, Integer> cache=new HashMap<>();
    public int getSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Fetching from cache...");
            return cache.get(num);
        } else {
            int square=num*num;
            cache.put(num, square);
            return square;
        }

    }

    public static void main(String[] args) {
        SquareCache sc=new SquareCache();
        System.out.println("Square of 4 is " + sc.getSquare(4));
        System.out.println("Square of 5 is " + sc.getSquare(5));
        System.out.println("Square of 4 is " + sc.getSquare(4));
    }
}
