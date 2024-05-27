/**
 * 이항계수 : 이항 정리로 전개했을 때 각 항의 계수, 주어진 크기의 (순서 없는 조합의 가짓수)
 * NCK
 */

import java.util.Scanner;

public class Main {
	
	static int N;
	static int K;
	static int[][] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		D = new int[N+1][N+1];
		
		comb();
		
		System.out.println(D[N][K]);
	}

	
	public static void comb() {
		for(int i = 0; i <= N; i++) {
			D[i][0] = 1;	// i개 중 1개도 안뽑는 경우
			D[i][1] = i;	// i개 중 1개만 뽑는 경우
			D[i][i] = 1;	// i개 다 뽑는 경우
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				D[i][j] = D[i-1][j] + D[i-1][j-1];	// i개 중 j개 = i-1개 중 j개 뽑는 경우(날 안뽑음) + i-1개 중 j-1개(날 뽑음)
			}
		}
		
	}
}
