import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = 0;
        
        if(a <= 23 && a >= 20) {
            result += (24 - a) + b;
        } else {
            result += b - a;
        }
        
        System.out.println(result);
    }
}