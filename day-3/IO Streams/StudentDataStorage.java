import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Student {
    int rollNumber;
    String name;
    double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public void displayStudent() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class StudentDataStorage {

    private static final String DATA_FILE = "student_data.dat";

    public static void storeStudent(Student student) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(DATA_FILE, true))) {
            dos.writeInt(student.rollNumber);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.err.println("Error storing student data: " + e.getMessage());
        }
    }

    public static void retrieveStudents() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(DATA_FILE))) {
            System.out.println("\n--- Retrieved Student Data ---");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                Student student = new Student(rollNumber, name, gpa);
                student.displayStudent();
                System.out.println("---");
            }
            System.out.println("End of student data.");
        } catch (IOException e) {
            System.err.println("Error retrieving student data: " + e.getMessage());
            if (e.getMessage().startsWith("No such file or directory")) {
                System.out.println("No student data file found yet.");
            }
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(101, "John Doe", 8.5);
        Student student2 = new Student(102, "Jane Smith", 9.2);
        Student student3 = new Student(103, "Peter Jones", 7.9);

        storeStudent(student1);
        storeStudent(student2);
        storeStudent(student3);

        retrieveStudents();
    }
}