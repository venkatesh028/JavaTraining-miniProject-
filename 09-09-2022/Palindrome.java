import java.util.Scanner;

/**
 * Get the value from the user and check it is Palindrome or not 
 *
 * @version 1.0 09-SEP-2022
 * @author Venkatesh TM  
 */
public class Palindrome {
    
    public static void checkPalindrome(String sentence) {
        String reverse = "";
        int length;
        length = sentence.length();
        
        for (int index = length - 1; index >=0; index--) {
            reverse = reverse + sentence.charAt(index);
        }
        
        if (sentence.equals(reverse)) {
            System.out.println(sentence + " is a palindrome string ");
        } else {
            System.out.println(sentence + " is not a palindrome string ");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string : ");
        checkPalindrome(scanner.nextLine());  
      
    }

}