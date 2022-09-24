import java.util.Scanner;

/**
 * Finds out the given number is duck number or not
 *
 * @version 1.0 12-SEP-2022
 * @author Venkatesh TM
 */
public class DuckNumber {
    public static boolean checkNumber(int number) {
        if (number%10 == 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number : ");
        number = scanner.nextInt();
        if (checkNumber(number)) {
            System.out.println("yes it is Duck Number");    
        } else{
            System.out.println("No it is not Duck Number");
        }
    }
}