class Animal0 {
    void sound() {
        System.out.println("Animal sound");
    }
}
class Dog1 extends Animal0{
    void bark() {
        System.out.println("Dog bark");
    }
}
public class DowncastingExample {
    public static void main(String[] args) {
        Animal0 a=new Dog1();
        if (a instanceof Dog1) {
            Dog1 d = (Dog1) a;
            a.sound();
            ((Dog1) a).bark();
            d.sound();
            d.bark();
        } else {
            System.out.println("Not a dog instance");
        }
    }
}