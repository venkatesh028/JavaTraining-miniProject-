public class Details<T> {
    private T data;
    
    public Details(T data){
        this.data = data;
    }
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data; 
    } 

} 