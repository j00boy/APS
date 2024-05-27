import java.util.Scanner;

public class Main {

	static int N; // 계단의 개수 <= 300
	static int[] D; // 10000 * 300 = 3,000,000
	static int[] scores; // 300

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		D = new int[N + 1];		
		scores = new int[N + 1];
		
		/*
		 * D[i] = i번째 칸을 밟았을 때 얻을 수 있는 최대 점수
		 * - 조건1: 1칸 or 2칸
		 * - 조건2: 3칸 연속 불가
		 * - 조건3: 마지막 칸은 무조건 밟음 (N번째 칸)
		 */

		for (int i = 1; i <= N; i++) {
			scores[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			if(i == 1) {
				D[1] = scores[1];
			} else if(i == 2) {
				D[2] = scores[1] + scores[2];
			} else if(i == 3) {
				D[3] = Math.max(scores[1] + scores[3], scores[2] + scores[3]);
			} else {
				// O X O O / ? O X O
				// i-2번쨰 + i번째 밟기 vs i-3번째 + i-1번쨰 + i번째 밟기
				D[i] = Math.max(D[i-3] + scores[i-1] + scores[i], D[i-2] + scores[i]);
			}
		}


		System.out.println(D[N]);
	}
	
	
}