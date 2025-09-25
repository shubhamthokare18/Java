package serializing;


import java.io.*;

class Student extends Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Serializable {

    public static void main(String[] args) {
        Student student=new Student(1,"Mahesh");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\syste\\Documents\\student.ser"));
            objectOutputStream.writeObject(student);
            System.out.println("SAVED");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("C:\\Users\\syste\\Documents\\student.ser")))
        {
            Student student1=(Student) objectInputStream.readObject();
            System.out.println(student1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}