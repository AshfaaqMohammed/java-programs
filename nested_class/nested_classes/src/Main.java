import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
//        Employee employee = new Employee(2,"Adi",1999);
//        System.out.println(employee);
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(6,"sumith",2025),
                new Employee(5,"adi",2025),
                new Employee(3,"srinivas",2024)
        ));
//        EmployeeComparator<Employee> employeeComparator = new EmployeeComparator<>();
//        employees.sort(employeeComparator);
        Employee.EmployeeComparator<Employee> comparator = new Employee.EmployeeComparator<>("yearStarted");
        employees.sort(comparator.reversed());
        for (var employee : employees){
            System.out.println(employee);
            System.out.println("-".repeat(10));
        }
    }
}