import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for versioning

    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeDataStorage {

    private static final String DATA_FILE = "employees.dat";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(employees);
            System.out.println("Employee data saved to " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Error saving employee data: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                employees = (List<Employee>) obj;
                System.out.println("Employee data loaded from " + DATA_FILE);
            } else {
                System.err.println("Error: Data file does not contain a list of employees.");
            }
        } catch (IOException e) {
            System.err.println("Error loading employee data: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Class Employee not found during deserialization.");
        }
        return employees;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "HR", 60000.00));
        employeeList.add(new Employee(102, "Bob", "IT", 75000.00));
        employeeList.add(new Employee(103, "Charlie", "Finance", 65000.00));

        saveEmployees(employeeList);

        List<Employee> loadedEmployees = loadEmployees();

        System.out.println("\nLoaded Employees:");
        for (Employee emp : loadedEmployees) {
            System.out.println(emp);
        }
    }
}