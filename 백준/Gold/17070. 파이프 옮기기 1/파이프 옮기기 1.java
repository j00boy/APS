import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] home;
	static boolean[][] visited;
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		home = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		count = 0;
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				home[r][c] = sc.nextInt();
			}
		}
		
		home[1][1] = 3;
		DFS(1, 2, 0);
		
		System.out.println(count);
	}
	
	public static void DFS(int r, int c, int dir) {
		if(r == N && c == N) {
			count++;
//			print();
			return;
		}
		
		home[r][c] = 3;
		
		if(dir == 0) {
			for(int d = 0; d < 2; d++) {

				if(d == 1) {
					if(!check(r, c+1) || !check(r+1, c) || home[r][c+1] != 0 || home[r+1][c] != 0) {
						continue;
					}
				}
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				
				if(check(nr, nc) && home[nr][nc] == 0) {
					DFS(nr, nc, d);
				}
			}
		} else if(dir == 1) {
			for(int d = 0; d < 3; d++) {
				
				if(d == 1) {
					if(!check(r, c+1) || !check(r+1, c) || home[r][c+1] != 0 || home[r+1][c] != 0) {
						continue;
					}
				}
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(check(nr, nc) && home[nr][nc] == 0) {
					DFS(nr, nc, d);
				}
			}
		} else {
			for(int d = 1; d < 3; d++) {
				
				if(d == 1) {
					if(!check(r, c+1) || !check(r+1, c) || home[r][c+1] != 0 || home[r+1][c] != 0) {
						continue;
					}
				}
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(check(nr, nc) && home[nr][nc] == 0) {
					DFS(nr, nc, d);
				}
			}
		}
		
		home[r][c] = 0;
	}
	
	public static boolean check(int r, int c) {
		return r >= 1 && r <= N && c >= 1 && c <= N;
	}
	
	public static void print() {
		System.out.println("----------------------");
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				System.out.print(home[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
}
