import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N; // 반지름
	static int M; // M개의 정수
	static int T; // 총 회전 수
	static boolean[][] visited;
	static int[][] map;
	static int[] info;
	static int[] tmp;
	static int total;
	static int cnt;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		total = 0;

		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		map = new int[N][M];
		info = new int[3]; // info[0]: x, info[1]: d, info[2]: k

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

//		print();
		// 총 T번 회전 + 그 안에서 돌아가는 메서드
		// - 일단 해당 회차 먼저 다 돌리고
		// - 그 다음에 인접한 것들 삭제
		for (int i = 0; i < T; i++) {
			info[0] = sc.nextInt();
			info[1] = sc.nextInt(); // info[1]: 0 = 시계 방향, info[1]: 1 = 반시계 방향
			info[2] = sc.nextInt();

			if (info[1] == 0) { // 시계 방향 회전
				for (int r = 0; r < N; r++) { // 모든걸 돌면서
					if ((r+1) % info[0] == 0) { // 배수일 때만
						tmp = new int[M];
						for (int c = M - info[2]; c < M; c++) {
							tmp[c - (M - info[2])] = map[r][c];
						}

						for (int c = 0; c < M - info[2]; c++) {
							tmp[c + info[2]] = map[r][c];
						}
//						System.out.println(Arrays.toString(tmp));
						
						for(int c = 0; c < M; c++) {
							map[r][c] = tmp[c];
						}
					}
				}
				
//				System.out.println(i + 1 + "회");
//				System.out.println("돌리기만 한 후");
//				print();
				

				// 숫자 제거 로직
				visited = new boolean[N][M];
				double sum = 0;
				double numCnt = 0;
				double avg = 0;
				count = 0;
				for (int r = 0; r < N; r++) { // 모든걸 돌면서
					for (int c = 0; c < M; c++) {
						if (map[r][c] != 0) {
							sum += map[r][c];
							numCnt++;
							
							if(!visited[r][c]) {
								cnt = 0;
								BFS(r, c, map[r][c]);								
							}
						}
					}
				}

				if (count == 0) {
//					System.out.println("평균빼기 시작");
					avg = sum / numCnt;
//					System.out.println(sum);
//					System.out.println(numCnt);
//					System.out.println(avg);

					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (map[r][c] != 0) {
								if (map[r][c] > avg) {
									map[r][c]--;
								} else if (map[r][c] < avg) {
									map[r][c]++;
								}
							}
						}
					}
				}

			} else { // 반시계 방향 회전
				for (int r = 0; r < N; r++) { // 모든걸 돌면서
					if ((r + 1) % info[0] == 0) { // 배수일 때만
						tmp = new int[M];
						for (int c = 0; c < info[2]; c++) {
							tmp[M - info[2] + c] = map[r][c];
						}

						for (int c = 0; c < M - info[2]; c++) {
							tmp[c] = map[r][c + info[2]];
						}
//						System.out.println(Arrays.toString(tmp));
						
						for(int c = 0; c < M; c++) {
							map[r][c] = tmp[c];
						}
					}
				}
//				System.out.println(i + 1 + "회");
//				System.out.println("돌리기만 한 후");
//				print();

				// 숫자 제거 로직
				visited = new boolean[N][M];
				double sum = 0;
				double numCnt = 0;
				double avg = 0;
				count = 0;
				for (int r = 0; r < N; r++) { // 모든걸 돌면서
					for (int c = 0; c < M; c++) {
						if (map[r][c] != 0) {
							sum += map[r][c];
							numCnt++;
							
							if(!visited[r][c]) {
								cnt = 0;
								BFS(r, c, map[r][c]);								
							}
						}
					}
				}

				if (count == 0) {
//					System.out.println("평균빼기 시작");
					avg = sum / numCnt;
//					System.out.println(sum);
//					System.out.println(numCnt);
//					System.out.println(avg);

					for (int r = 0; r < N; r++) {
						for (int c = 0; c < M; c++) {
							if (map[r][c] != 0) {
								if (map[r][c] > avg) {
									map[r][c]--;
								} else if (map[r][c] < avg) {
									map[r][c]++;
								}
							}
						}
					}
				}
			}
//			System.out.println("모든 셈을 한 후");
//			print();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				total += map[r][c];
			}
		}

		System.out.println(total);

	}
	
	static void BFS(int r, int c, int value) {
		cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.add(r);
		queue.add(c);
		
		while(!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				if(nc >= 0) {
					nc = nc % M;
				} else {
					nc = M - 1;
				}
				
				if (check(nr) && map[nr][nc] == value) {
					visited[nr][nc] = true;
					map[nr][nc] = 0;
					queue.add(nr);
					queue.add(nc);
					cnt++;
				}
			}
		}
		
		if(cnt > 0) {
			map[r][c] = 0;
			count++;
		}
	}

	static boolean check(int r) {
		return r >= 0 && r < N;
	}

	static void print() {
		System.out.println("--------------------");
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
}