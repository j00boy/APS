import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int K;
	static List<Integer> coins = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			coins.add(sc.nextInt());
		}
		
		Collections.sort(coins, Collections.reverseOrder());
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			if(K / coins.get(i) >= 1) {
				int cnt = K / coins.get(i);
				count += cnt;
				K -= coins.get(i) * cnt;
				
				if(K == 0) {
					System.out.println(count);
					break;
				}
			}
		}
		
	}
}
