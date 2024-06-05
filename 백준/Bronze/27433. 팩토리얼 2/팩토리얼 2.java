import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long ans = 1;
        long n = sc.nextLong();
        
        if(n == 0) {
            System.out.println(ans);
        } else {
            
            for(int i = 1; i <= n; i++) {
                ans = (long) ans * i;
            }
            
            System.out.println(ans);
        }
    }
}