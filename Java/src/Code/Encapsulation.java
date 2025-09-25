class Person {
    private String name;
    public String getname() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.setName("John");
        System.out.println(myObj.getname());
    }
}
