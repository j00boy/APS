import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < 3; i++) {
            list.add(sc.nextInt());
        }
        
        Collections.sort(list);
        
        System.out.println(list.get(1));
    }
}