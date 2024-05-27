import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int[][] D;
	static int[][] adj;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		adj = new int[N][N];
		D = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			Arrays.fill(adj[r], -1);
		}
		
		for(int r = 0; r < N; r++) {
			for(int c= 0; c <= r; c++) {
				adj[r][c] = sc.nextInt();
			}
		}
		
		D[0][0] = adj[0][0];
		
		for(int r = 1; r < N; r++) {
			for(int c= 0; c <= r; c++) {
				if(c == 0) {
					D[r][c] = D[r-1][c] + adj[r][c];
				} else if(c == r) {
					D[r][c] = D[r-1][c-1] + adj[r][c];
				} else {
					D[r][c] = Math.max(D[r-1][c-1], D[r-1][c]) + adj[r][c];
				}
			}
		}
		
		int max = 0;
		for(int c = 0; c < N; c++) {
			if(D[N-1][c] > max) {
				max = D[N-1][c];
			}
		}
		
		System.out.println(max);
	}
	
	
}
