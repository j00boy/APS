import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;
        for(int i = 0; i < 8; i++) {
            int n = sc.nextInt();
            
            if(n == 9) {
                flag = false;
            }
        }
        
        if(flag) {
            System.out.println("S");
        } else {
            System.out.println("F");
        }
    }
}