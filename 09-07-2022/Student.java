import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Student class have the name and id of the student
 * sort the student based on alphabetical order
 *
 * @ author Venkatesh TM
 * @ version 1.0;
 **/
public class Student {
    
    /**
     * Takes the students and sort in alphabetical order
     * and return the sorted name 
     * @ param {Map students}
     * @ return {Map result}
     */
    public static Map sortMap(Map students) {
        List<Entry<Integer,String>> studentList = new LinkedList<>(students.entrySet());
        Collections.sort(studentList,(list1, list2) -> list1.getValue().compareTo(list2.getValue()));
        Map<Integer,String> result = new LinkedHashMap<>();
        
        for (Map.Entry<Integer,String> entry : studentList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;        
    }

    public static void main(String[] args) {
        Map<Integer,String> students = new LinkedHashMap<>();
        students.put(18066,"Venkatesh");
        students.put(18032,"Aakash");
        students.put(18044,"Ravi");
        students.put(18055,"Gokul");
        
        Map<Integer,String> inOrder = sortMap(students);      
        System.out.println(inOrder); 
       
    }
}