import java.util.Map;
import java.util.HashMap;

public class Student {
    public static void main(String[] arg) {
        Map<Integer,String> names = new HashMap<>();
        names.put(1,"Venkatesh");
        names.put(2,"aakash");
        names.put(3,"dillip");
        
        for(Map.Entry<Integer,String> entry : names.entrySet()) {
            System.out.println("Key = " +entry.getKey() +
                               " Value = " +entry.getValue());       
        }
        
    }
}