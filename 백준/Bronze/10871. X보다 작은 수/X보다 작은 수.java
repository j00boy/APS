import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int X = sc.nextInt();
        
        String answer = "";
        
        for(int i = 0; i < N; i++) {
            int num = sc.nextInt();
            
            if(num < X) {
                answer += num + " ";
            }
        }
        
        System.out.println(answer);
    }
}