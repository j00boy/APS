import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*
        구호 SONGDO에 대해 HIGHSCHOOL로 응원.
        구호 CODE에 대해 MASTER로 응원.
        구호 2023에 대해 0611로 응원.
        구호 ALGORITHM에 대해 CONTEST로 응원.
        */
        
        String str = sc.next();
        
        if(str.equals("SONGDO")) {
            System.out.println("HIGHSCHOOL");
        } else if(str.equals("CODE")) {
            System.out.println("MASTER");
        } else if(str.equals("2023")) {
            System.out.println("0611");
        } else {
            System.out.println("CONTEST");
        }
    }
}