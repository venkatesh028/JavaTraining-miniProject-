import java.io.Console;

/**
 * Hiding the password in console when the user enter the password
 *
 * @version 1.0
 * @author Venkatesh TM
 */

public class Hide {

    public void passwordExample() {        
        Console console = System.console();

        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        console.printf("Password entered was: %s%n", new String(passwordArray));
    }

    public static void main(String[] args) {
        new Hide().passwordExample();
    }
}