import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int money = 100 * N;
        
        if(money >= M) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}