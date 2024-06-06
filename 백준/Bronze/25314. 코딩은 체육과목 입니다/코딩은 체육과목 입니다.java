import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        String ans = "";
        
        int num = n / 4;
        
        for(int i = 0; i < num; i++) {
            ans += "long ";
        }
        
        ans += "int";
        
        System.out.println(ans);
    }
}