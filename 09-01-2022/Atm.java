import java.util.Set;
import java.util.HashSet;

public class Atm {
    public static void main(String[] args) {
        Set<Integer> atmPins = new HashSet<>();
        atmPins.add(123);
        atmPins.add(323);
        atmPins.add(123);
        atmPins.add(677);   
        System.out.println(atmPins);     
    }
}