import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int price = 0;
        
        for(int i = 0; i < n; i++) {
            price += sc.nextInt();
        }
        
        System.out.println(price);
    }
}