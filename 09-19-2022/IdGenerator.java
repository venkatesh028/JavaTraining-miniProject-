import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Generate Id for the students
 * 
 * @version 1.0 19-SEP-2022
 * @author Venkatesh TM
 */
public class IdGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> students = new HashMap<>();
        int count;
        String name;
        System.out.print("Enter count of the names : ");
        count = scanner.nextInt();
        scanner.nextLine();

        for (int index = 0; index < count; index++) {
            System.out.print("Enter student Name : ");
            name  = scanner.nextLine();
            String id = UUID.randomUUID().toString();
            students.put(id, name);
        }
        
        System.out.println(students);
        
    }
}