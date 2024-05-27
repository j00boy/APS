import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] n_visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		n_visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			String str = sc.next();
			for(int c = 0; c < M; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}

		int[] start = {0, 0, 0, 1};
		
		int result = BFS(start);
		
		System.out.println(result);
		
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	public static int BFS(int[] arr) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(arr);
		
		visited[arr[0]][arr[1]] = true;
		
		// 97프로... 
		if(arr[0] == N-1 && arr[1] == M-1) {
			return arr[3];
		}
		
		while(!queue.isEmpty()) {
			
			int[] now = queue.poll();
			
			int now_r = now[0];
			int now_c = now[1];
			int now_breakWall = now[2];
			int now_count = now[3];
			
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				
				// 정석으로 갈 때 + 벽을 부순 적이 없음
				if(check(nr, nc) && map[nr][nc] == 0 && now_breakWall == 0 && !visited[nr][nc]) {
					if(nr == N-1 && nc == M-1) {
						return now_count+1;
					}
					queue.add(new int[] {nr, nc, 0, now_count + 1});
					visited[nr][nc] = true;
					
				// 정석으로 가는데, 이미 벽을 부신적이 있다면 n_visited에 체크하면서 감
				} else if(check(nr, nc) && map[nr][nc] == 0 && now_breakWall == 1 && !n_visited[nr][nc]) {
					if(nr == N-1 && nc == M-1) {
						return now_count+1;
					}
					queue.add(new int[] {nr, nc, 1, now_count + 1});
					n_visited[nr][nc] = true;
					
				// 부신 적이 없는 상태에서 벽을 만나면, 부순다.
				} else if(check(nr, nc) && map[nr][nc] == 1 && now_breakWall == 0) {
					if(nr == N-1 && nc == M-1) {
						return now_count+1;
					}
					queue.add(new int[] {nr, nc, 1, now_count + 1});
					n_visited[nr][nc] = true;
				} 
			}
		}
		
		return -1;
	}
	
	
}