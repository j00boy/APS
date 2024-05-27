import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
            String str = sc.next();
            int end = str.length() - 1;
            
            System.out.println("" + str.charAt(0) + str.charAt(end));
        }
    }
}