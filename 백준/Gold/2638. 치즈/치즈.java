import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
//	static int air;
	static int cheese;
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] outerAir;
	static int hour;
	static List<int[]> meltingSpot;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		hour = 0;
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		outerAir = new boolean[N][M];
		cheese = 0;
//		air = 0;	// 외부공기 잘 찍히는지 디버깅하려고
		
		// 처음 값
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) {	// 치즈 개수만 미리 세놓기
					cheese++;
				}
			}
		}
		
		// 외부공기 체크
		connectOuterAir(0, 0);		// 가장자리는 치즈가 놓이지 않는 것으로 간주하므로, 0,0은 무조건 외부공기가 됨
//		System.out.println(air);
//		System.out.println(cheese);
//		print();
		
		if(cheese == 0) {			// 치즈가 없으면 굳이 녹일 필요가 없으므로 0 리턴
			System.out.println(0);
			return;
		}
		
		while(cheese > 0) {
			connectOuterAir(0, 0);
			meltingSpot = new ArrayList<>();	// 녹는 치즈 애들을 담을 배열
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[r][c] == 1) {		// 치즈이면서 
						if(checkMeltingCondition(r, c)) {	// 녹는 애들이라면
							meltingSpot.add(new int[] {r, c});	// 녹는 애들을 리스트에 따로 담고
						}
					}
				}
			}
			melt();		// 여기서 녹임
//			print();
		}

		System.out.println(hour);
	}
	
	// 치즈 녹이기
	public static void melt() {
		for(int[] arr : meltingSpot) {
			int r = arr[0];
			int c = arr[1];
			map[r][c] = 0;
			outerAir[r][c] = true;
		}
		
		hour++;
		cheese -= meltingSpot.size();
	}
	
	// 외부 공기끼리 연결
	public static void connectOuterAir(int r, int c) {
		outerAir = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		outerAir[r][c] = true;
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(check(nr, nc) && map[nr][nc] == 0 && !outerAir[nr][nc]) {
					outerAir[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}
		}
	}
	
	// 4방 탐색
	public static boolean checkMeltingCondition(int r, int c) {
		
		int adj = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(outerAir[nr][nc]) {
				adj++;
			}
		}
		
		// 외부공기와 맞닿아 있는 것이 2변 이상이라면
		if(adj >= 2) {
			return true;
		}
		
		return false;	// 1개만 맞닿아있거나 아니라면 false 
	}
	
	// 경계조건 체크 함수
	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
	
	// 디버깅
	public static void print() {
		System.out.println("------------------------------------");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------");
	}
}