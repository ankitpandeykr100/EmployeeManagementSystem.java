import java.io.*;

// Serializable Student class
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    int studentID;
    String name;
    String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class StudentSerializationDemo {
    public static void main(String[] args) {
        String filename = "student.ser";

        // Serialization
        Student s1 = new Student(101, "Alice", "A");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(s1);
            System.out.println("Student object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Student object deserialized:");
            s2.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
