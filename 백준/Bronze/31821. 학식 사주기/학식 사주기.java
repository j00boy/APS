import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] price = new int[N];
        for(int i = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }
        
        int total = 0;
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int order = sc.nextInt() - 1;
            total += price[order];
        }
        
        System.out.println(total);
    }
}