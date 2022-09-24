public class Main {
    public static void main(String[] args) {
        String name = "Venkatesh";
        Student student = new Student(name);
        Details<String> names = new Details<>(name);
        Details<Student> data = new Details<>(student);
        System.out.println(names.getData());
        System.out.println(data.getData());
             
    }    
}