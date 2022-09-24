public class Employee {
    String name;
    int Id;
    
    public Employee(String name, int Id) {
        this.name = name;
        this.Id = Id;    
    }
    
    public String toString() {
        return "name = "+name + " ID = "+ Id;
    }
    
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Employee other = (Employee)obj;
        if(Id != other.Id)
            return false;   
        return true;     
    }
  
    public int hashCode() {
         final int prime = 31;
         int result = 1;
         result = prime * result + Id;
         result = prime * result + ((name == null) ? 0 : name.hashCode());
         return result;
     } 
}
