import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Insted of stoping the programing handling the error
 * and get the input until he enter the string
 *
 * @version 1.0 
 * @author Venkatesh TM
 */
public class Handler {

    /**
     * Get the input from the user if the exception got thrown then
     * It get handled and asked to repeat the 
     */
    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        int input;
        try{
            input = scanner.nextInt();    
        } catch(InputMismatchException e) {
            System.out.println("Enter Only Number not String ");
            return getInput();
        }
        return input;
    }

    public static void main(String[] args) {
        int value;
        Handler handler = new Handler();
        System.out.println("Enter the Integer : ");
        value = handler.getInput();
                   
    }
}