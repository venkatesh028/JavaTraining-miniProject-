import java.util.Scanner;

/**
 * Getting the password in a string format and then converting it into 
 * Character array to ensure Password hiding
 *
 * @version 1.0
 * @author Venkatesh TM
 */
public class Password {
  
    public static void main(String[] args) {  
        String password;
        char[] characterPassword;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the password : ");
        password = scanner.nextLine();
        characterPassword = password.toCharArray();
        
        System.out.println("Normal format : " + password);
        System.out.println("Character format : " + characterPassword);
            
    }
}