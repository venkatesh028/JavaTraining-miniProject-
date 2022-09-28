import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Try to handel the exception thrown 
 * 
 * @version 1.0
 * @author Venkatesh TM
 */
public class Transport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int selectedOption = 0;
        final int FLIGHT = 1;
        final int BUS = 2;
        final int BIKE = 3;
        final int EXIT = 4;
        StringBuffer message = new StringBuffer();
        message.append("\nEnter ").append(FLIGHT)
               .append(" To choose the Flight")
               .append("\nEnter ").append(BUS)
               .append(" To choose the Bus")
               .append("\nEnter ").append(BIKE)
               .append(" To choose the bike")
               .append("\nEnter ").append(EXIT)
               .append(" TO exit ");
     try {
        while (isRunning) {
            System.out.print(message);

            
            	selectedOption = scanner.nextInt();

            switch (selectedOption) {
            case FLIGHT:
                System.out.println("Here is your Flight Ticket ");
                break;

            case BUS:
                System.out.println("Here is your Bus Ticket ");
                break;

            case BIKE:
                System.out.println("Here is money for the Petrol");
                break;

            case EXIT:
                isRunning = false;
                break;

            default:
                System.out.println("Enter the given option");
                break;
            }
          }

            } catch (InputMismatchException e) {
                main(new String[1] );
            }
        
    }

}