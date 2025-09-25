public class Polymorphism {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}
class Dog0 extends Polymorphism {
    public void animalSound() {
        System.out.println("Bow Bow");
    }
}
class Main0 {
    public static void main(String[] args) {
        Polymorphism animal = new Polymorphism();
        Dog0 myDog = new Dog0();
        animal.animalSound();
        myDog.animalSound();
    }
}