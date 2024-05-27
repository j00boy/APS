import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static List<Integer> plus;
	static List<Integer> minus;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();
		plus = new ArrayList<>();
		minus = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			plus.add(r + c);
			minus.add(r - c);
		}
		
		Collections.sort(plus);
		Collections.sort(minus);
		
		int ans = Math.max(plus.get(plus.size() - 1) - plus.get(0), minus.get(minus.size() - 1) - minus.get(0));
		
		System.out.println(ans);
	}
}
