import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Department {
    HR,
    IT,
    FINANCE,
    SALES
}

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class EmployeeGrouper {
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departmentMap = new HashMap<>();
        for (Employee employee : employees) {
            Department department = employee.getDepartment();
            departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }
        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));
        employees.add(new Employee("David", Department.FINANCE));
        employees.add(new Employee("Eve", Department.IT));

        Map<Department, List<Employee>> groupedEmployees = groupByDepartment(employees);
        System.out.println("Employees: " + employees);
        System.out.println("Output:");
        groupedEmployees.forEach((department, employeeList) ->
                System.out.println(department + ": " + employeeList));
    }
}