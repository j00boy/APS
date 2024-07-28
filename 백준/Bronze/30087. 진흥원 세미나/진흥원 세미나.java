import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            
            if(str.equals("Algorithm")) {
                System.out.println("204");
            } else if(str.equals("DataAnalysis")) {
                System.out.println("207");
            } else if(str.equals("ArtificialIntelligence")) {
                System.out.println("302");
            } else if(str.equals("CyberSecurity")) {
                System.out.println("B101");
            } else if(str.equals("Network")) {
                System.out.println("303");
            } else if(str.equals("Startup")) {
                System.out.println("501");
            } else {
                System.out.println("105");
            }
        }
        
        /*
        Algorithm	204
DataAnalysis	207
ArtificialIntelligence	302
CyberSecurity	B101
Network	303
Startup	501
TestStrategy	105
            */
    }
}