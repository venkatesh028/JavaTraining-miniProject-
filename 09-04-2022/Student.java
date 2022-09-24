public class Student<T> {
    private T name;
    
    public Student(T name) {
        this.name = name;
    }
   
    public T getData() {
        return name;
    }
}