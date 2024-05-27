import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}

		int totalCount = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visited[r][c]) {
					cnt = 0;
					totalCount++;
					DFS(r, c);
					list.add(cnt);
				}
			}
		}

		System.out.println(totalCount);
		Collections.sort(list);
		for(int i : list) {
			System.out.println(i);
		}

	}

	public static void DFS(int r, int c) {

		cnt++;
		
		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		
		int cnt = 1;

		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc)) {
				if (map[nr][nc] == 1 && !visited[nr][nc]) {
					DFS(nr, nc);
				}
			}
		}
		

	}

	public static boolean check(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}

}