import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

//		File file = new File("src/BOJ_11652_카드/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1 <= N <= 100000
		long[] cards = new long[N];
		
		Map<Long, Integer> map = new HashMap<>();

		// test case 시작
		for (int i = 0; i < N; i++) {
			// - 2^62 <= num <= 2^62
			cards[i] = sc.nextLong();
		}
		
		
		for(int i = 0; i < N; i++) {
			if(map.isEmpty() || map.get(cards[i]) == null) {
				map.put(cards[i], 1);
			} else {
				int tmp = map.get(cards[i]);
				map.replace(cards[i], tmp+1);
			}
		}
		
//		System.out.println(map);
		
		int maxCount = Integer.MIN_VALUE;
		for(int n : map.values()) {
			if(n > maxCount) {
				maxCount = n;
			}
		}
		
		
		long minKey = Long.MAX_VALUE;
		for(long key : map.keySet()) {
			if(map.get(key) == maxCount) {
				if(key < minKey) {
					minKey = key;
				}
			}
		}
		System.out.println(minKey);
		
//		}
//		 test case 끝
	}
}