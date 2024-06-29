import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        int seconds = a+b+c+d;
        
        int min = seconds / 60;
        int sec = seconds % 60;
        
        System.out.println(min);
        System.out.println(sec);
    }
}