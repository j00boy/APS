import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static List<int[]> list;
	static int min;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		min = Integer.MAX_VALUE;
		
		list = new ArrayList<>();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] >= 1 && map[r][c] <= 5) {
					list.add(new int[] {r, c});
				}
			}
		}
		
		cctv(0);
		
		System.out.println(min);
	}
	
	static void cctv(int count) {
		if(count >= list.size()) {
			// 여기서 사각지대 구하는 함수
			int sum = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(map[r][c] == 0) {
						sum++;
					}
				}
			}
			
			min = Math.min(min, sum);
			return;
		}
		
		int row = list.get(count)[0];
		int col = list.get(count)[1];
		
		if(map[row][col] == 1) {
			Stack<int[]> recovery = new Stack<>();
			for(int d = 0; d < 4; d++) {
				int next_r = row + dr[d];
				int next_c = col + dc[d];
				
				while(check(next_r, next_c)) {
					if(map[next_r][next_c] == 0) {
						map[next_r][next_c] = 9;
						recovery.add(new int[] {next_r, next_c});
					}
					next_r += dr[d];
					next_c += dc[d];
				}
				cctv(count + 1);
				
				while(!recovery.isEmpty()) {
					int[] point = recovery.pop();
					map[point[0]][point[1]] = 0;
				}
			}
			
		} else if(map[row][col] == 2) {
			for(int d = 0; d < 2; d++) {
				Stack<int[]> recovery = new Stack<>();
				if(d == 0) {	// 좌우
					int next_r = row + dr[0];
					int next_c = col + dc[0];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[0];
						next_c += dc[0];
					}
					
					next_r = row + dr[2];
					next_c = col + dc[2];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[2];
						next_c += dc[2];
					}
					
					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
					
				} else {		// 상하
					int next_r = row + dr[1];
					int next_c = col + dc[1];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[1];
						next_c += dc[1];
					}
					
					next_r = row + dr[3];
					next_c = col + dc[3];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[3];
						next_c += dc[3];
					}
					
					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
				}
			}
		} else if(map[row][col] == 3) {
			for(int d = 0; d < 4; d++) {
				Stack<int[]> recovery = new Stack<>();
				if(d == 0) {
					int next_r = row + dr[0];
					int next_c = col + dc[0];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[0];
						next_c += dc[0];
					}
					
					next_r = row + dr[3];
					next_c = col + dc[3];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[3];
						next_c += dc[3];
					}
					
					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
					
				} else if(d == 1) {
					int next_r = row + dr[0];
					int next_c = col + dc[0];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[0];
						next_c += dc[0];
					}
					
					next_r = row + dr[1];
					next_c = col + dc[1];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[1];
						next_c += dc[1];
					}
					
					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
					
				} else if(d == 2) {
					int next_r = row + dr[1];
					int next_c = col + dc[1];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[1];
						next_c += dc[1];
					}
					
					next_r = row + dr[2];
					next_c = col + dc[2];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[2];
						next_c += dc[2];
					}
					
					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
					
				} else if(d == 3) {
					int next_r = row + dr[2];
					int next_c = col + dc[2];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[2];
						next_c += dc[2];
					}
					
					next_r = row + dr[3];
					next_c = col + dc[3];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[3];
						next_c += dc[3];
					}
					
					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
				} 
			}
		} else if(map[row][col] == 4) {
			for(int d = 0; d < 4; d++) {
				Stack<int[]> recovery = new Stack<>();
				if(d == 0) {
					int next_r = row + dr[0];
					int next_c = col + dc[0];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[0];
						next_c += dc[0];
					}
					
					next_r = row + dr[1];
					next_c = col + dc[1];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[1];
						next_c += dc[1];
					}
					
					next_r = row + dr[2];
					next_c = col + dc[2];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[2];
						next_c += dc[2];
					}

					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
				} else if(d == 1) {
					int next_r = row + dr[1];
					int next_c = col + dc[1];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[1];
						next_c += dc[1];
					}
					
					next_r = row + dr[2];
					next_c = col + dc[2];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[2];
						next_c += dc[2];
					}
					
					next_r = row + dr[3];
					next_c = col + dc[3];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[3];
						next_c += dc[3];
					}

					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
				} else if(d == 2) {
					int next_r = row + dr[2];
					int next_c = col + dc[2];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[2];
						next_c += dc[2];
					}
					
					next_r = row + dr[3];
					next_c = col + dc[3];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[3];
						next_c += dc[3];
					}
					
					next_r = row + dr[0];
					next_c = col + dc[0];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[0];
						next_c += dc[0];
					}

					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
				} else if(d == 3) {
					int next_r = row + dr[3];
					int next_c = col + dc[3];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[3];
						next_c += dc[3];
					}
					
					next_r = row + dr[0];
					next_c = col + dc[0];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[0];
						next_c += dc[0];
					}
					
					next_r = row + dr[1];
					next_c = col + dc[1];
					while(check(next_r, next_c)) {
						if(map[next_r][next_c] == 0) {
							map[next_r][next_c] = 9;
							recovery.add(new int[] {next_r, next_c});
						}
						next_r += dr[1];
						next_c += dc[1];
					}

					cctv(count + 1);
					
					while(!recovery.isEmpty()) {
						int[] point = recovery.pop();
						map[point[0]][point[1]] = 0;
					}
				} 
			}
		} else if(map[row][col] == 5) {
			Stack<int[]> recovery = new Stack<>();
			int next_r = row + dr[0];
			int next_c = col + dc[0];
			while(check(next_r, next_c)) {
				if(map[next_r][next_c] == 0) {
					map[next_r][next_c] = 9;
					recovery.add(new int[] {next_r, next_c});
					
				}
				next_r += dr[0];
				next_c += dc[0];
			}
			
			next_r = row + dr[1];
			next_c = col + dc[1];
			while(check(next_r, next_c)) {
				if(map[next_r][next_c] == 0) {
					map[next_r][next_c] = 9;
					recovery.add(new int[] {next_r, next_c});
				}
				next_r += dr[1];
				next_c += dc[1];
			}
			
			next_r = row + dr[2];
			next_c = col + dc[2];
			while(check(next_r, next_c)) {
				if(map[next_r][next_c] == 0) {
					map[next_r][next_c] = 9;
					recovery.add(new int[] {next_r, next_c});
				}
				next_r += dr[2];
				next_c += dc[2];
			}
			
			next_r = row + dr[3];
			next_c = col + dc[3];
			while(check(next_r, next_c)) {
				if(map[next_r][next_c] == 0) {
					map[next_r][next_c] = 9;
					recovery.add(new int[] {next_r, next_c});
				}
				next_r += dr[3];
				next_c += dc[3];
			}

			cctv(count + 1);
			
			while(!recovery.isEmpty()) {
				int[] point = recovery.pop();
				map[point[0]][point[1]] = 0;
			}
		}
		
	}
	
	static void print() {
		System.out.println("=========================");
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && map[r][c] != 6;
	}
}
