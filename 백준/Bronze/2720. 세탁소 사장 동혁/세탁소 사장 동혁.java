import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		Integer[] coins = {10, 5, 1, 25};
		Arrays.sort(coins, Collections.reverseOrder());
		
		for(int tc = 1; tc <= T; tc++) {
			int change = sc.nextInt();
			int count = 0;
			
			for(int i = 0; i < 4; i++) {
				int tmp = change;
				count = tmp / coins[i];
				change %= coins[i];
				System.out.print(count + " ");
			}
			
			System.out.print("\n");
		}
	}
}
