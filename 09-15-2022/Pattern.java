import java.util.Scanner;

/**
 * Print the * pattern 
 * 
 * @version 1.0
 * @author Venkatesh TM
 */
public class Pattern {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number : ");
        number = scanner.nextInt();
        
        for (int outerLine = 0; outerLine < number; outerLine++) {
            for(int innerLine = 0; innerLine <= outerLine; innerLine++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}