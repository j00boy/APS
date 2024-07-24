import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
/*        
Print 0 if the number does not contain 7 and is not divisible by 7.
Print 1 if the number does not contain 7 but is divisible by 7.
Print 2 if the number does contain 7 but is not divisible by 7.
Print 3 if the number does contain 7 and is divisible by 7.
*/
        
        if(a % 7 == 0) {
            String str = "" + a;
            char[] arr = str.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '7') {
                    System.out.println(3);
                    return;
                }
            }
            System.out.println(1);
        } else {
            String str = "" + a;
            char[] arr = str.toCharArray();
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '7') {
                    System.out.println(2);
                    return;
                }
            }
            System.out.println(0);
        }
    
    }
}