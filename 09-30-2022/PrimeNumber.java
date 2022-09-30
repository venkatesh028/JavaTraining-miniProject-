import java.util.Scanner;

/**
 * Finding the given number is prime number or not
 *  
 * @version 1.0 
 * @author Venkatesh TM
 */
public class PrimeNumber{
    public static void main(String[] args) { 
        int number;
        int flag = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number : ");
        number = scanner.nextInt();

        if (number == 0) {
            System.out.println(number + " is not Prime number ");
        } else {
            for (int index = 2; index < number; index++) {
                if (number % index == 0) {
                    System.out.print(number + "is not prime number ");
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 0) {
            System.out.println(number + " is prime number");
        }
    }
}