import java.util.Scanner;

public class Main {
	
	static int R;
	static int C;
	static char[][] board;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] alphabets = new int[26];
	static int count = 0;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String str = sc.next();
			for(int c = 0; c < C; c++) {
				board[r][c] = str.charAt(c);
			}
		}
		
		DFS(0, 0);
		
		System.out.println(max);
		
	}
	
	public static void DFS(int r, int c) {
		
		alphabets[board[r][c]-65]++;
		count++;
		max = Math.max(max, count);
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc) && alphabets[board[nr][nc]-65] == 0) {
				DFS(nr, nc);
			}
		}
		
		alphabets[board[r][c]-65]--;
		count--;
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C; 
	}
}
