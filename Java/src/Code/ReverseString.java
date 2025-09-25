public class ReverseString {
    public static void main(String[] args) {
        String orignal = "Hello";
        String reverse = "";
        System.out.println("Orignal: " + orignal);
        for(int i =0; i < orignal.length(); i++) {
            reverse = orignal.charAt(i) + reverse;
        }
        System.out.println("Reverse: " + reverse);
    }
}
