import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * gets the value in set then converts to the array
 *
 * @version 1.0 14-SEP-2022
 * @author Venkatesh TM
 */
public class Student {
    public static void main(String[] args) {
        int totalStudent = 5;
        String name;
        String[] studentNames;
        Set<String> names = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        for (int index = 0; index < totalStudent; index++) {
            System.out.print("Enter student name : ");
            name = scanner.nextLine();
            names.add(name);
        }
        
        //Converting the set to array
        studentNames = names.toArray(new String[0]);
        
        for (int index = 0; index < totalStudent; index++) {
            System.out.println(studentNames[index]);
        }
        
    }
}