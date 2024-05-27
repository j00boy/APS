import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] len;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		len = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			String str = sc.next();
			for(int c = 0; c < M; c++) {
				map[r][c] = Character.getNumericValue(str.charAt(c));
			}
		}
		
		BFS(0, 0);
		
		System.out.println(len[N-1][M-1]);
		
		
	}
	
	public static void BFS(int r, int c) {
		// 큐 생성
		Queue<int[]> queue = new LinkedList<>();
		
		// 사방 탐색
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		// 탐색 시작 노드를 큐에 삽입
		queue.add(new int[] {r, c});
		len[r][c] = 1;			// 해당 깊이 저장할 배열 생성	
		visited[r][c] = true;	// 방문 체크
		
		while(!queue.isEmpty()) {
			int[] loc = queue.poll();	// 가장 위에꺼를 빼서
			
			// 해당 좌표 사방 탐색
			for(int d = 0; d < 4; d++) {
				int nr = loc[0] + dr[d];
				int nc = loc[1] + dc[d];
				
				// 경계 조건 가능
				if(check(nr, nc)) {
					if(map[nr][nc] == 1 && !visited[nr][nc]) {	// 1이면서 방문하지 않은 노드라면
						visited[nr][nc] = true;					// 방문체크
						len[nr][nc] = len[loc[0]][loc[1]]+1;	// 해당 좌표 깊이 + 1
						queue.add(new int[] {nr, nc});			// 큐에 삽입
					}
				}
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}