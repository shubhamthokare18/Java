public class Inheritance {
    protected String brand = "Ford";
}
class Car extends Inheritance {
    private String modelName = "Mustang";

    public static void main(String[] args) {
       Car myCar = new Car();
        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}
class Vehicle {

}