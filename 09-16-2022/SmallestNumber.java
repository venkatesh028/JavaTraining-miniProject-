import java.util.Scanner;

/**
 * Finds the smallest number using ternary operator
 *
 * @version 1.0 16-SEP-2022
 * @author  Venkatesh TM
 */
public class SmallestNumber {
    public static void main(String[] args) {
        int number1;
        int number2;
        int number3;
        int smallest;
        int temporary;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        number1 = sc.nextInt();
        System.out.println("Enter the second number:");
        number2 = sc.nextInt();
        System.out.println("Enter the third number:");
        number3 = sc.nextInt();

        temporary=number1<number2?number1:number2;

        smallest=number3<temporary?number3:temporary;

        System.out.println("The smallest number is: "+smallest);
    }
}