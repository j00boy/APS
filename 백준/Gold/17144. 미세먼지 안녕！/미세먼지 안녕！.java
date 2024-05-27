import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("src/boj_17144_미세먼지안녕/input.txt"));

		int R = sc.nextInt();
		int C = sc.nextInt();
		int T = sc.nextInt();

		int[][] room = new int[R][C];
		int[] row = new int[2];
		int[] col = new int[2];
		int idx = 0;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] = sc.nextInt();
				if (room[r][c] == -1) {
					row[idx] = r;
					col[idx] = c;
					idx++;
				}
			}
		}

		// T초의 시간 동안
		for (int time = 1; time <= T; time++) {
			int[][] newRoom = new int[R][C];
			newRoom[row[0]][col[0]] = -1;
			newRoom[row[1]][col[1]] = -1;
			// 상 하 좌 우
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			// 먼지 확산
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					int tmp = room[r][c];
					// 0이면 실행 X
					if (tmp == 0 || tmp == -1) {
						continue;
					}

					int count = 0;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
							if (room[nr][nc] == -1) {
								continue;
							} else {
								newRoom[nr][nc] += tmp / 5;
								count++;
							}
						}
					}

					newRoom[r][c] += tmp - ((tmp / 5) * count);
				}
			}
			
			// 상 우 하 좌
			int[] ddr = { -1, 0, 1, 0 };
			int[] ddc = { 0, 1, 0, -1 };

			// 하 우 상 좌
			int[] dddr = { 1, 0, -1, 0 };
			int[] dddc = { 0, 1, 0, -1 };

			int[][] airRoom = new int[R][C];
			// 공기 청정기 작동
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					// 공기 청정기 위
					if (r == row[0] && c == col[0]) {
						airRoom[r][c] = -1;
						
						for(int i = 0; i < C-1; i++) {
							airRoom[r][i+1] = newRoom[r][i];
							if(airRoom[r][i+1] == -1) airRoom[r][i+1] = 0;
						}
						
						for(int i = r-1; i >= 0; i--) {
							airRoom[i][C-1] = newRoom[i+1][C-1];
						}
						
						for(int i = C-2; i >= 0; i--) {
							airRoom[0][i] = newRoom[0][i+1];
						}
						
						for(int i = 1; i < r; i++) {
							airRoom[i][0] = newRoom[i-1][0];
						}
						
					}

					// 공기 청정기 아래
					if (r == row[1] && c == col[1]) {
						airRoom[r][c] = -1;
						
						for(int i = 0; i < C-1; i++) {
							airRoom[r][i+1] = newRoom[r][i];
							if(airRoom[r][i+1] == -1) airRoom[r][i+1] = 0;
						}
						
						for(int i = r+1; i < R; i++) {
							airRoom[i][C-1] = newRoom[i-1][C-1];
						}
						
						for(int i = C-2; i >= 0; i--) {
							airRoom[R-1][i] = newRoom[R-1][i+1];
						}
						
						for(int i = R-2; i > r; i--) {
							airRoom[i][0] = newRoom[i+1][0];
						}
						
					}
				}
			}
			
			for(int r = 1; r <= row[0]-1; r++) {
				for(int c = 1; c < C-1; c++) {
					airRoom[r][c] = newRoom[r][c];
				}
			}
			
			for(int r = row[1] + 1; r < R - 1; r++) {
				for(int c = 1; c < C-1; c++) {
					airRoom[r][c] = newRoom[r][c];
				}
			}

			// 다시 방을 바꿈
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					room[r][c] = airRoom[r][c];
				}
			}
		}

//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++) {
//				System.out.printf("%2d ", room[r][c]);
//			}
//			System.out.println();
//		}

//		 방에 남아있는 미세먼지의 양
		int result = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(room[r][c] == -1) {
					continue;
				}
				result += room[r][c];
			}
		}

		System.out.println(result);
	}

}
