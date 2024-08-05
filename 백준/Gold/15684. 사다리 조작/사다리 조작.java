import java.util.Scanner;

public class Main {

	static int N; // 세로선의 개수
	static int M; // 가로선의 개수
	static int H; // 세로선마다 가로선을 놓을 수 있는 위치의 개수

	static int[][] map;
	static int min;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		min = Integer.MAX_VALUE;

		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();

		map = new int[H + 1][N + 1];
		
		if(M == 0) {
			System.out.println(0);
		} else {
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
				map[a][b + 1] = -1;
			}
			
			for(int i = 0; i <= 3; i++) {
				bridge(0, i);
				if(min != Integer.MAX_VALUE) {
					break;
				}
			}

			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		}
		
	}
	
	static void bridge(int count, int target) {
		if(min != Integer.MAX_VALUE) return;
		
		if(count == target) {
			if(isOK()) {
				min = Math.min(min, target);
			}
			return;				
		}
		
		for(int r = 1; r <= H; r++) {
			for(int c = 1; c < N; c++) {
				if(map[r][c] == 0 && map[r][c + 1] == 0) {
					map[r][c] = 1;
					map[r][c + 1] = -1;
					bridge(count + 1, target);
					map[r][c] = 0;
					map[r][c + 1] = 0;
				}
			}
		}
	}
	
	static boolean isOK() {
		for(int i = 1; i <= N; i++) {
			int c = i;
			for(int r = 1; r <= H; r++) {
				if(map[r][c] == 1) {
					c++;
				} else if(map[r][c] == -1) {
					c--;
				}
			}
			
			if(c != i) {
				return false;
			}
		}
		
		return true;
	}
}
