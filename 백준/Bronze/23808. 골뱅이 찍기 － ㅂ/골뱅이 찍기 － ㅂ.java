import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        String s1 = "";
        String s2 = "";
        
        // s1 += n * "@";
        for(int i = 0; i < n; i++) {
            s1 += "@";
        }
        
        // s1 += " " * (3*n);
        for(int i = 0; i < 3 * n; i++) {
            s1 += " ";
        }
        
        // s1 += n * "@";
        for(int i = 0; i < n; i++) {
            s1 += "@";
        }
        
        // s2 += 5 * n * "@";
        for(int i = 0; i < 5 * n; i++) {
            s2 += "@";
        }
        
        for(int i = 0; i < 2 * n; i++) {
            System.out.println(s1);
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(s2);
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(s1);
        }
        
        for(int i = 0; i < n; i++) {
            System.out.println(s2);
        }
    }
}