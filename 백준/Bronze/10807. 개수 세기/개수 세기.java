import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] counts = new int[201];
        
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt() + 100;
            counts[a]++;
        }
        
        int V = sc.nextInt() + 100;
        
        System.out.println(counts[V]);
    }
}