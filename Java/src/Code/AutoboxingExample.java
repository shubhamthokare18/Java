public class AutoboxingExample {
    public static void main(String[] args) {
        int num=50;
        Integer boxed=num;
        System.out.println("Autoboxed Integer object: " + boxed);
        Integer anotherBoxed=51;
        int unboxed=anotherBoxed;
        System.out.println("Unboxed int value: " + unboxed);
    }
}
