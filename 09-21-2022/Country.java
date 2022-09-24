import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Country {
    public static void main(String[] args) {
        Map<Integer, String> country = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
	int countryNumber;
        int numberOfCountry;
	String countryName;
        
        System.out.print("Enter number of country : ");
        numberOfCountry = scanner.nextInt();

        for (int index = 0; index < numberOfCountry; index++) {
	    System.out.println("Enter country number : ");
	    countryNumber = scanner.nextInt();
	    scanner.skip("\r\n");
	    System.out.println("Enter the country name :");
	    countryName = scanner.nextLine();
            country.put(countryNumber, countryName);
        }
        System.out.println(country);            
    }
}   
