import java.util.Scanner;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter two integers");
        int n1=s.nextInt();
        int n2=s.nextInt();
        try {
            int r=n1/n2;
            System.out.println("Result: " + r);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }
}