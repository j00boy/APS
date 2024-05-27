import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] counts = new int[31];
        
        for(int i = 0; i < 28; i++) {
            counts[sc.nextInt()]++;
        }
        
        for(int i = 1; i <= 30; i++) {
            if(counts[i] == 0) {
                System.out.println(i);
            }
        }
    }
}