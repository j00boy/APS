import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String target = sc.next();
        String str = target.substring(0, 5);
        
        int num = sc.nextInt();
        
        int count = 0;
        for(int i = 0; i < num; i++) {
            String subject = sc.next();
            if(subject.substring(0, 5).equals(str)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}