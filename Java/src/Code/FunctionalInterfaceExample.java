@FunctionalInterface
interface MyCalculator {
    int calculate(int a, int b);
}
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyCalculator add=(a, b)->a+b;
        System.out.println("Sum: " + add.calculate(5, 3));
        MyCalculator multiply=(a, b)->a*b;
        System.out.println("Product: " + multiply.calculate(5, 3));
    }
}
