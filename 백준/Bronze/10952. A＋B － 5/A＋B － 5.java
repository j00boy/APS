import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if(a == 0 && b == 0) {
                flag = false;
                break;
            }
            
            System.out.println(a + b);
        }

}
}