import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] map;
	static int count;
	static int[] dr = {-1, -1, -1};
	static int[] dc = {-1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		count = 0;

		DFS(0);
		
		System.out.println(count);
		
	}
	
	public static void DFS(int r) {		// 행 당 하나씩 이니까 열 탐색은 함 수 안에서
		if(r == N) {		// 끝까지 가면 가능하다는 뜻 -> count++
			count++;
			return;
		}
		
		for(int c = 0; c < N; c++) {	// 그 행의 열 탐색
			
			boolean flag = true;

			int now_r = r;
			int now_c = c;
			
			for(int d = 0; d < 3; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				
				while(check(nr, nc)) {
					if(map[nr][nc] == 1) {
						flag = false;
						break;
					}
					nr += dr[d];
					nc += dc[d];
				}
				
				if(!flag) {
					break;
				}
			}
			
			
			if(flag) {
				map[r][c] = 1;				// 1로 바꾸고
				DFS(r + 1);
			}
			
			map[r][c] = 0;					// 다시 초기화
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}