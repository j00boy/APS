import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] room;
	static int[] dr = { -1, 0, 1, 0 }; // 북 동 남 서
	static int[] dc = { 0, 1, 0, -1 }; // 북 동 남 서
	static int startR;
	static int startC;
	static int d;
	static boolean[][] visited;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		room = new int[N][M];

		startR = sc.nextInt();
		startC = sc.nextInt();
		d = sc.nextInt();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				room[r][c] = sc.nextInt();
			}
		}

		clean(startR, startC, d);

		System.out.println(cnt);
	}

	public static void clean(int r, int c, int d) {

		if (room[r][c] == 0) {
			room[r][c] = 3;
			cnt++;
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(room[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}

		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (room[nr][nc] != 0) {
				count++;
			}
		}

		if (count == 4) {
			int nr = r + dr[(d + 2) % 4];
			int nc = c + dc[(d + 2) % 4];
			if (check(nr, nc) && room[nr][nc] != 1) {
				clean(nr, nc, d);
			} else {
				return;
			}
		}
		
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && room[nr][nc] == 0) {
				flag = false;
				clean(nr, nc, d);
				return;
			}
		}

//		if(!flag) {
//			int nr = r + dr[(d + 2) % 4];
//			int nc = c + dc[(d + 2) % 4];
//			if (check(nr, nc) && room[nr][nc] != 1) {
//				clean(nr, nc, d);
//			} else {
//				return;
//			}
//		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
