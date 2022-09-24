import java.util.Scanner;

/**
 * It finds out the given number is Spy number or not
 *
 * @version 1.0 13-SEP-2022
 * @author Venkatesh TM
 */
public class SpyNumber {

    public static void main(String[] args) {
        int number;
        int product = 1;
        int sum = 0;
        int lastDigit;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number to check : ");
        number = scanner.nextInt();
        
        while(number > 0) {
            lastDigit = number % 10;
            sum = sum + lastDigit;
            product = product * lastDigit;
            number = number / 10;
        }    
        if (sum == product) {
            System.out.println("The given number is a spy number");
        } else {
            System.out.println("The given number is not a spy number"); 
        } 
    }
}