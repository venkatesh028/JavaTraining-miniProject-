import java.util.Scanner;

public class UserName {
    
    private boolean isValidName(String name) {
        return name.matches("^[\\s]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validName = true;
        String name = " ";
        UserName userName = new UserName();

        while (validName) { 
            System.out.print("Enter your name : ");
            name = scanner.nextLine();
            
            if (!userName.isValidName(name)) {
                validName = false;
            } 
        }
        
        System.out.println("Your name is : " + name);        
    }
    
}