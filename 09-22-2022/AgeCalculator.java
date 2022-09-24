import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * Calculate the age based on  the dateOfbirth 
 *
 * @version 1.0
 * @author Venkatesh TM
 */
public class AgeCalculator {
    
    /**
     * Calculate the age with the birthdate and currentdate 
     *
     * @param  birthDate birth date of the user
     * @param  currentDate current date of the year
     * @return age         age of the user
     */
    public int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        Period age;
        if ((birthDate != null) && (currentDate != null)) {
            age = Period.between(birthDate, currentDate);
            return age.getYears();
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        AgeCalculator ageCalculator = new AgeCalculator();
        String dob;
        Scanner scanner = new Scanner(System.in);
        LocalDate dateOfBirth;
        LocalDate currentDate;        
        System.out.print("Enter your DOB : ");
        dob = scanner.nextLine();
        dateOfBirth = LocalDate.parse(dob);
        currentDate = LocalDate.now();        
        System.out.println(ageCalculator.calculateAge(dateOfBirth, currentDate));
    }
}
