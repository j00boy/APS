import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for(int i = 1; i <= N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
        
            int result = A + B;
            
            System.out.println("Case #" + i + ": " + result);
        }
        
    }
}