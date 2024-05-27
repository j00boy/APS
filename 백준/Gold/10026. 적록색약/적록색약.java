import java.util.Scanner;

public class Main {

	static int N;
	static String[][] painting;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		// 적록색약 : 빨간색과 초록색의 차이를 거의 느끼지 못함
		painting = new String[N][N];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				painting[r][c] = String.valueOf(str.charAt(c));
			}
		}
		
		// 정상인 DFS
		visited = new boolean[N][N];
		int normalCnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					normalDFS(r, c, painting[r][c]);
					normalCnt++;
				}
			}
		}

		// 적록색약 DFS
		visited = new boolean[N][N];
		int disabledCnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					disabledDFS(r, c, painting[r][c]);
					disabledCnt++;
				}
			}
		}
		
		System.out.println(normalCnt + " " + disabledCnt);
	}

	public static void normalDFS(int r, int c, String color) {

		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && !visited[nr][nc] && painting[nr][nc].equals(color)) {
				normalDFS(nr, nc, color);
			}
		}
	}

	public static void disabledDFS(int r, int c, String color) {
		
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if(color.equals("R") || color.equals("G")) {
				if (check(nr, nc) && !visited[nr][nc] && painting[nr][nc].equals("R") || check(nr, nc) && !visited[nr][nc] && painting[nr][nc].equals("G")) {
					disabledDFS(nr, nc, color);
				}
			} else {
				if (check(nr, nc) && !visited[nr][nc] && painting[nr][nc].equals(color)) {
					disabledDFS(nr, nc, color);
				}
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
