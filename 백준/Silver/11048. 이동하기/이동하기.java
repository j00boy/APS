import java.util.Scanner;

public class Main {
	
	static int[] dr = {1, 0, 1};
	static int[] dc = {0, 1, 1};
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] D;
	static int maxSum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		maxSum = Integer.MIN_VALUE;
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		D = new int[N][M];
		
		visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		D[0][0] = map[0][0];
		
		for(int c = 1; c < M; c++) {
			D[0][c] = D[0][c-1] + map[0][c];
		}
		
		for(int r = 1; r < N; r++) {
			D[r][0] = D[r-1][0] + map[r][0];
		}
		
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < M; c++) {
				D[r][c] = Math.max(Math.max(D[r-1][c], D[r][c-1]), D[r-1][c-1]) + map[r][c];
			}
		}
		
		System.out.println(D[N-1][M-1]);
		
	}
	
}
