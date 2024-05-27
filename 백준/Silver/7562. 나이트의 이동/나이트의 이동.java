import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int I;
	static int[][] board;
	static int knight_r;
	static int knight_c;
	static int destination_r;
	static int destination_c;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			I = sc.nextInt();
			board = new int[I][I];
			
			knight_r = sc.nextInt();
			knight_c = sc.nextInt();
//			board[knight_r][knight_c] = 1;
			
			destination_r = sc.nextInt();
			destination_c = sc.nextInt();
//			board[destination_r][destination_c] = 1;
			
			BFS(knight_r, knight_c);
			
			System.out.println(board[destination_r][destination_c] - 1);
			
		}
		// test case
	}
	
	public static void BFS(int r, int c) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		// 나이트가 가능한 이동 경로
		int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
		
		queue.add(r);
		queue.add(c);
		board[r][c] = 1;
		
		while(!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();
			
			for(int d = 0; d < 8; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				if(check(nr, nc) && board[nr][nc] == 0) {
					queue.add(nr);
					queue.add(nc);
					board[nr][nc] = board[now_r][now_c] + 1;
					
					if(nr == destination_r && nc == destination_c) {
						return;
					}
				}
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < I && c >= 0 && c < I;
	}

}
