import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int H;
	static int[][][] tomatoes;
	// 상 하 좌 우 위 아래 
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	static Queue<Integer> queue = new LinkedList<>();	// BFS를 위한 queue 생성
	// Why? 토마토가 하루가 지날때마다 동시에 번식하기 때문에 
	static int day = 0;	// 모두 번식할 수 있을 경우의 날짜값 저장 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 같은 배열을 H칸 쌓아 올림 
		M = sc.nextInt();	// 가로 줄의 개수 
		N = sc.nextInt();	// 세로 줄의 개수 
		H = sc.nextInt();	// 높이 
		tomatoes = new int[N][M][H];
		
		// 토마토 배열 입력받기
		// [r][c][0]이 가장 윗칸
		boolean hasZero = false;	// 0이 하나도 없는 상황이라면 다 익었다고 치기 때문에 0으로 출력 
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					tomatoes[r][c][h] = sc.nextInt();
					if(tomatoes[r][c][h] == 1) {		// 미리 토마토 위치 저장 -> BFS 를 위함
						queue.add(r);
						queue.add(c);
						queue.add(h);
						queue.add(0);
					}
					if(tomatoes[r][c][h] == 0) {
						hasZero = true;
					}
				}
			}
		}
		
		if(!hasZero) {	// 0이 하나도 없다면, 애초에 번식을 할 필요가 없기 떄문에 0
			System.out.println(0);
		} else {
			growTomatoes();
			boolean isPossible = true;	// 0이 하나라도 발견되면, 번식은 끝났는데 영향이 끼쳐지지 않음 
			for(int h = 0; h < H; h++) {
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < M; c++) {
						if(tomatoes[r][c][h] == 0) {
							System.out.println(-1);
							isPossible = false;
							return;
						}
					}
				}
			}
			
			if(isPossible) {
				System.out.println(day);
			}
		}
		
		
		
	}
	
	static void growTomatoes() {					// BFS
		while(!queue.isEmpty()) {
			int now_r = queue.poll();	// 행 값 
			int now_c = queue.poll();	// 열 값 
			int now_h = queue.poll();	// 높이 값 
			int now_day = queue.poll();	// 날짜 값 
			
			for(int d = 0; d < 6; d++) {	// 6방 탐색 
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				int nh = now_h + dh[d];
				int nday = now_day + 1;		// 내가 탐색하는 것이 다음 날짜 번식에 대한 탐색이기 때문에 + 1
				
				if(check(nr, nc, nh) && tomatoes[nr][nc][nh] == 0) {
					queue.add(nr);
					queue.add(nc);
					queue.add(nh);
					queue.add(nday);
					tomatoes[nr][nc][nh] = 1;
					if(nday > day) {	// day에 대한 max 값 갱신 
						day = nday;
					}
				}
			}
		}
	}
	
	// 경계 조건
	static boolean check(int r, int c, int h) {
		return r >= 0 && r < N && c >= 0 && c < M && h >= 0 && h < H;
	}
	
}
