import java.util.Scanner;
public class DaySwitch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number (1-3)");
        int day = s.nextInt();
        switch (day) {
            case 1:
                System.out.println("Mon");
                break;
            case 2:
                System.out.println("Tue");
                break;
            case 3:
                System.out.println("Wed");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}