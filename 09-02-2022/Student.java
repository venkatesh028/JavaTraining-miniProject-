import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> names = new LinkedList<>();
        int count;
        System.out.println("Enter the total number of Students : ");
        count = scanner.nextInt();
        scanner.nextLine();
        
        for (int index = 0; index < count; index++) {
            System.out.print("Enter name : ");
            names.offer(scanner.nextLine());                
        }
        
        String removedName = names.poll();
        System.out.println("Removed name : " + removedName);
        System.out.println("Queue after deletion : " + names);       
    }
}