import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        String answer = "";
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 65 && ch <= 90) {
                String c = "" + ch;
                answer += c.toLowerCase();
            } else {
                String c = "" + ch;
                answer += c.toUpperCase();
            }
        }
        
        System.out.println(answer);
    }
}