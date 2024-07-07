import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < 2; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            
            System.out.print(6 * a + 3 * b + 2 * c + d + 2 * e + " ");
        }
    }
}