import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        int rows;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        rows = scanner.nextInt();
        for (int index=0; index < rows; index++) {
 
            for (int index_j=rows-index; index_j>1; index_j--) { 
                System.out.print(" "); 
            }  

            for (int index_j = 0; index_j <= index; index_j++ ) { 
                System.out.print("* "); 
            } 
  
            System.out.println();
        } 
    }
}