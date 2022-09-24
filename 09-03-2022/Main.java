import java.util.Set;
import java.util.HashSet;

public class Main { 
    public static void main(String[] args) {
        Set<Employee> employee = new HashSet<>();
        Employee details1 = new Employee("Venkatesh", 101);
        Employee details2 = new Employee("Venkatesh", 101);        
        employee.add(details1);
        employee.add(details2);
        System.out.println(employee);           
    }
}