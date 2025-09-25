public class Student {
    String name;
    int rollNo;
    Student(String name, int rollNo) {
        this.name=name;
        this.rollNo=rollNo;
    }
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }

    public static void main(String[] args) {
        Student s = new Student("Shubham", 1239);
        s.displayDetails();
    }
}
