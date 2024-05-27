import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int side;
	static int N; // 크기 지수
	static int Q; // 파이어스톰 시전 횟수
	static boolean[][] visited;
	static int[][] map;
	static int[][] copied;
	static int sum;
	static int max;
	static int L; // 시전 단계
	static int Lside;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sum = 0;
		max = 0;

		N = sc.nextInt();
		Q = sc.nextInt();

		side = (int) Math.pow(2, N);

		map = new int[side][side];
		copied = new int[side][side];
		visited = new boolean[side][side];

		for (int r = 0; r < side; r++) {
			for (int c = 0; c < side; c++) {
				map[r][c] = sc.nextInt();
			}
		}

//		print(map);

		for (int i = 0; i < Q; i++) {
			Queue<int[]> q = new LinkedList<>();
			L = sc.nextInt();
			Lside = (int) Math.pow(2, L);
			divideAndRotate(Lside);
			copy();
			
			for(int r = 0; r < side; r++) {
				for(int c = 0; c < side; c++) {
					if(map[r][c] > 0) {
						int adj = fireStorm(r, c);
						if(adj < 3) {
							q.add(new int[] {r, c});
						}
					}
				}
			}
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				map[now[0]][now[1]]--;
			}
//			print(copied);
		}
		
		for(int r = 0; r < side; r++) {
			for(int c = 0; c < side; c++) {
				sum += map[r][c];
				if(map[r][c] > 0 && !visited[r][c]) {
					max = Math.max(max, getDummy(r, c));
				}
			}
		}

//		print(copied);
		
		System.out.println(sum);
		System.out.println(max);


	}
	
	static int fireStorm(int r, int c) {
		
		int count = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc) && map[nr][nc] > 0) {
				count++;
			}
		}
		
		return count;
	}

	static void divideAndRotate(int part) {
		for (int startR = 0; startR < side; startR += part) {
			for (int startC = 0; startC < side; startC += part) {
				for (int r = startR; r < startR + part; r++) {
					for (int c = startC; c < startC + part; c++) {
						// startR = 0, startC = 0;
						// r = {0,1,2,3}, c = {0,1,2,3}
						
						// part = 4
						
						// startR = 0, startC = 4;
						// r = {0,1,2,3}, c = {4,5,6,7}
						
						/*
						 	1 0 -> 0 2
							1 1 -> 1 2
							1 2 -> 2 2
							1 3 -> 3 2
							
							2 4 -> 0 5
							2 5 -> 1 5
							2 6 -> 2 5
							2 7 -> 3 5
							
							4 4 -> 4 7
							4 5 -> 5 7
							4 6 -> 6 7
							4 7 -> 7 7
						 */
						copied[c - startC + startR][startR + startC + part - 1 - r] = map[r][c];
//						System.out.println("(" + r + ", " + c + ")");
					}
				}
			}
		}
	}
	
	static int getDummy(int r, int c) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 1;
		visited[r][c] = true;
		queue.add(r);
		queue.add(c);
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int now_r = queue.poll();
			int now_c = queue.poll();
			int now_dist = queue.poll();
			max = Math.max(max, now_dist);
			
			for(int d = 0; d < 4; d++) {
				int nr = now_r + dr[d];
				int nc = now_c + dc[d];
				int ndist = now_dist + 1;
				
				if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
					visited[nr][nc] = true;
					queue.add(nr);
					queue.add(nc);
					queue.add(ndist);
					count++;
				}
			}
		}
		
		return count;
	}
	
	static void copy() {
		for(int r = 0; r < side; r++) {
			for(int c = 0; c < side; c++) {
				map[r][c] = copied[r][c];
			}
		}
	}
	
	static void print(int[][] arr) {
		System.out.println("----------------------");
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < side && c >= 0 && c < side;
	}

}