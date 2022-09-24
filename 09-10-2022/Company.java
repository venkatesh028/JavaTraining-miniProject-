import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/** 
 * Tried to give multiple values fro one Key 
 * with the help of list
 *
 * @version 1.0 10-SEP-2022
 * @author Venkatesh TM
 */
public class Company {
   public static void main(String[] args) {
       Map<String,List<String>> companies = new HashMap<>();
       List<String> Cities = new ArrayList<>();
       Scanner scanner = new Scanner(System.in); 
       String companyName;
       int noOfBranch;
       String cityName;
       System.out.print("Enter your company name : ");
       companyName = scanner.nextLine();
       System.out.print("In how many conutry your company is located : ");
       noOfBranch = scanner.nextInt();
       scanner.nextLine();
       for (int index = 0; index < noOfBranch; index++) {
           System.out.print("Enter city name : ");  
           Cities.add(scanner.nextLine());
       }   
    
       companies.put(companyName,Cities);
       System.out.println(companies);
   }
                    
}