import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Customizing the priority for the given values based on
 * our condition by overrideing the compare from comparator class 
 *
 * @author Venkatesh TM
 * @version 1.0;
 */
class CustomIntegerComparator implements Comparator<Integer> {
    public int compare(Integer i1, Integer i2) {
        return i1 < i2 ? 1 : -1;
    }
} 


public class Priority {
    
    public static void main(String[] args) {
        Queue<Integer> numbers = new PriorityQueue<>(new CustomIntegerComparator());
        numbers.add(11);
        numbers.add(-1);
        numbers.add(23);
        numbers.add(1);
        numbers.add(2);   
        
        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }    
    }
}