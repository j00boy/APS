import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int zeroMax = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 세로 길이
		M = sc.nextInt(); // 가로 길이
		map = new int[N][M]; // 맵 초기화

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		/*
		 * 2 0 0 0 1 1 0
		 * 0 0 1 0 1 2 0
		 * 0 1 1 0 1 0 0
		 * 0 1 0 0 0 0 0
		 * 0 0 0 0 0 1 1
		 * 0 1 0 0 0 0 0
		 * 0 1 0 0 0 0 0
		 */

		// 벽을 세우는 조건(?)
		// - 완전 탐색으로 일일이 하나씩 비교?
		// - 한 변의 길이가 최대 8이니까 가능할 수도
		// - 시간복잡도: 완탐(64*64*64) * BFS(64) = 16,777,216

		// 브루트포스
		// 굳이 벽이 3개가 아니여도 상관이 없는게,
		// 벽을 0에만 칠 수 있음.
		// 근데 벽을 조금만 치게 되면, 그만큼 바이러스를 차단할 수 없게 되는 것이기 때문에 0의 최댓값보다 작아지게 됨
		// 따라서 끝 점에서 0이 세 개가 되는 한계점을 찾아줄 필요가 없게 된다. 
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					for (int i = r; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if (map[i][j] == 0) {
								map[i][j] = 1;
								for (int x = i; x < N; x++) {
									for (int y = 0; y < M; y++) {
										if (map[x][y] == 0) {
											map[x][y] = 1;
											BFSandGetMaxCount();						// BFS를 하고, 다시 원복해야 함
											map[x][y] = 0;
										}
									}
								}
								map[i][j] = 0;
							}
						}
					}
					map[r][c] = 0;
				}
			}
		}

		System.out.println(zeroMax);

	}

	public static void BFSandGetMaxCount() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		// 현재 맵을 먼저 복사
		int[][] copiedMap = new int[N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				copiedMap[r][c] = map[r][c];
				
				// 바이러스 근원지가 여러 개이면, 동시다발적으로 퍼지기 때문에 먼저 queue에 삽입
				if(copiedMap[r][c] == 2) {
					queue.add(r);
					queue.add(c);
				}
			}
		}
		
		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];

				// 경계조건 + 0인 지점으로만 바이러스가 퍼질 수 있음
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && copiedMap[nr][nc] == 0) {
					queue.add(nr);
					queue.add(nc);
					copiedMap[nr][nc] = 2;
				}
			}
		}
		
		// 0의 갯수를 체크
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(copiedMap[r][c] == 0) {
					cnt++;
				}
			}
		}
		
		// max값과 비교 & 크면 갱신
		if(zeroMax < cnt) {
			zeroMax = cnt;
		}
	}

}