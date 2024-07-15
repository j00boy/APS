import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int[][] map;
	static int max;
	
	static int[][] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[M + 1][N + 1];
		D = new int[M + 1][N + 1];
		max = 0;
		
		for(int r = 1; r <= M; r++) {
			for(int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		for(int r = 1; r <= M; r++) {
			for(int c = 1; c <= N; c++) {
				if(map[r][c] == 1) {
					D[r][c] = 0;
				} else if(map[r][c] == 2) {
					D[r][c] = 0;
				} else {
					D[r][c] = Math.min(Math.min(D[r-1][c], D[r][c-1]) + 1, D[r-1][c-1] + 1);
					max = Math.max(max, D[r][c]);
				}
			}
		}
		
//		print(D);
		System.out.println(max);
	}
	
	public static void print(int[][] arr) {
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}
}
