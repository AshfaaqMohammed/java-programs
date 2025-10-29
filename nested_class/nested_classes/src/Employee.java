import java.util.Comparator;

public class Employee {
    private int employeeId;
    private String name;
    private int yearStarted;

    public static class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

        private String sortType;

        public EmployeeComparator(){
            this("name");
        }

        public EmployeeComparator(String sortType){
            this.sortType = sortType;
        }
        @Override
        public int compare(Employee o1, Employee o2){
            if (!sortType.equalsIgnoreCase("name")){
                int result = Integer.valueOf(o1.yearStarted).compareTo(Integer.valueOf(o2.yearStarted));
                if (result == 0){
                    result = Integer.valueOf(o1.employeeId).compareTo(Integer.valueOf(o2.employeeId));
                }
                return result;
            }else{
                return o1.name.compareTo(o2.name);
            }

        }

    }

    public Employee(){

    }
    public Employee(int employeeId, String name, int yearStarted){
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "%d %-8s %d".formatted(employeeId,name,yearStarted);
    }
}
