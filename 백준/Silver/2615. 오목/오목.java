import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[19][19];
		
		for(int r = 0; r < 19; r++) {
			for(int c= 0; c < 19; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		/*
		 * 검은 돌: 1
		 * 흰 돌: 2
		 */
		
		int row = Integer.MAX_VALUE;
		int col = Integer.MAX_VALUE;
		
		// 델타 배열
		// 우 하 우하 우상
		int[] dr = {0, 1, 1, -1};
		int[] dc = {1, 0, 1, 1};
		
		
		// 1 검사
		for(int r = 0; r < 19; r++) {
			for(int c = 0; c < 19; c++) {
				if(map[r][c] == 1 || map[r][c] == 2) {
					for(int d = 0; d < 4; d++) {
						int count = 1;
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						boolean isOK = true;
						while(isOK) {
							if(nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
								if(map[nr][nc] == map[r][c]) {
									count++;
									nr += dr[d];
									nc += dc[d];
								} else {
									isOK = false;
									break;
								}
							} else {		// 범위를 벗어나면
								isOK = false;
								break;
							}
						}
						
						if(count == 5) {
							nr = r - dr[d];
							nc = c - dc[d];
							
							if(nr >= 0 && nr < 19 && nc >= 0 && nc < 19) {
								if(map[nr][nc] != map[r][c]) {
									row = r + 1;
									col = c + 1;
									System.out.println(map[r][c]);
									System.out.println(row + " " + col);
									return;
								} else {
									continue;
								}
							} else {
								row = r + 1;
								col = c + 1;
								System.out.println(map[r][c]);
								System.out.println(row + " " + col);
								return;
							}
						}
					}
					
				}
			}
		}
		if(row >= 19 || col >= 19) {
			System.out.println(0);
		}
	}
}