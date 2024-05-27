import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        if(N == 0) {
            System.out.println(1);
        } else if(N == 1){
            System.out.println(1);
        } else {
            int answer = 1;
            for(int i = N; i > 0; i--) {
                answer *= i;
            }
            
            System.out.println(answer);
        }
    }
}