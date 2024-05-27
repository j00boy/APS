import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int connected;
	static char[][] map;
	static boolean[][] visited;
	static int count;
	static int total;
	static boolean puyo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		map = new char[12][6];
		count = 0;
		total = 0;
		
		for(int r = 0; r < 12; r++) {
			String str = sc.next();
			for(int c = 0; c < 6; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
//		System.out.println("처음");
//		print();
		
		puyo = true;
		while(puyo) {
			play();
			remap();
//			System.out.println("수정 후");
//			print();
		}
		
		System.out.println(total);
		
	}
	
	public static void play() {
		count = 0;
		visited = new boolean[12][6];
		for(int r = 0; r < 12; r++) {
			for(int c = 0; c < 6; c++) {
				if(map[r][c] != '.' && !visited[r][c]) {
					connected = 0;
					checkBomb(r, c, map[r][c]);
					if(connected >= 4) {
						bomb(r, c, map[r][c]);
//						print();
						count++;
					}
				}
			}
		}
		if(count == 0) {
			puyo  = false;
		} else {
			count = 1;
		}
		
		total += count;
	}
	
	public static void checkBomb(int r, int c, char ch) {
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		connected++;
		
		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];
				
				if(check(nr, nc) && !visited[nr][nc] && map[nr][nc] == ch) {
					visited[nr][nc] = true;
					connected++;
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
	}
	
	public static void bomb(int r, int c, char ch) {
		
		map[r][c] = '.';
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr, nc) && map[nr][nc] == ch) {
				bomb(nr, nc, ch);
			}
		}
	}
	
	public static void remap() {
		for(int c = 0; c < 6; c++) {
			String str = "";
			for(int r = 11; r >= 0; r--) {
				if(map[r][c] != '.') {
					str += map[r][c];
				}
				map[r][c] = '.';
			}
			
			int len = str.length();
			if(len == 0) continue;
			for(int r = 0; r < len; r++) {
				map[11-r][c] = str.charAt(r);
			}
		}
	}
	
	public static boolean check(int r, int c) {
		return r >= 0 && r < 12 && c >= 0 && c < 6;
	}
	
	public static void print() {
		System.out.println("-------------");
		for(int r = 0; r < 12; r++) {
			for(int c = 0; c < 6; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
}