import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int K;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] map;
	static List<int[]> list;
	static List<Integer> answer;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		list = new ArrayList<>();
		answer = new ArrayList<>();
		count = 0;
		
		M = sc.nextInt();	// 행 크기
		N = sc.nextInt();	// 열 크기
		K = sc.nextInt();	// K개의 직사각형
		
		map = new int[M][N];
		for(int i = 0; i < M; i++) {
			Arrays.fill(map[i], 1);
		}
		
		visited = new boolean[M][N];
		/*
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 * 0 0 0 0 0 0 0
		 */
		
		for(int i = 0; i < K; i++) {
			int start_c = sc.nextInt();
			int start_r = sc.nextInt();
			int end_c = sc.nextInt();
			int end_r = sc.nextInt();
			
			list.add(new int[] {start_r, start_c, end_r-1, end_c-1});
		}
				
		alreadyVisited();
		
		visited = new boolean[M][N];
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					int a = BFS(r, c);
					answer.add(a);
					count++;
				}
			}
		}
		
		
		Collections.sort(answer);
		
		System.out.println(count);
		for(int i : answer) {
			System.out.print(i + " ");
		}
		
	}
	
	public static void alreadyVisited() {
		for(int[] arr : list) {
			
			int start_r = arr[0];
			int start_c = arr[1];
			int end_r = arr[2];
			int end_c = arr[3];
			
			for(int r = start_r; r <= end_r; r++) {
				for(int c = start_c; c <= end_c; c++) {
					map[r][c] = 0;
					visited[r][c] = true;
				}
			}
		}
	}
	
	public static int BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		
		visited[r][c] = true;
		map[r][c] = 3;
		int cnt = 1;
		
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					map[nr][nc] = 3;
					queue.add(new int[] {nr, nc});
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}
}
