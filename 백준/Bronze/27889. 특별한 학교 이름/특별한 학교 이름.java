import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        
        if(str.equals("NLCS")) {
            System.out.println("North London Collegiate School");
        } else if(str.equals("BHA")) {
            System.out.println("Branksome Hall Asia");
        } else if(str.equals("KIS")) {
            System.out.println("Korea International School");
        } else {
            System.out.println("St. Johnsbury Academy");
        }
        
        /*
        NLCS: North London Collegiate School
        BHA: Branksome Hall Asia
        KIS: Korea International School
        SJA: St. Johnsbury Academy
        */
    }
}