import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[] dr = { 0, 1, 0, -1 }; // 좌 하 우 상
	static int[] dc = { -1, 0, 1, 0 }; // 좌 하 우 상

	static List<Integer> list;
	static int index;
	static int N; // N은 무조건 홀수
	static int[][] map;
	static int nowR;
	static int nowC;
	static int move;
	static int trash;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		list = new ArrayList<>();
		trash = 0;
		move = 1;
		N = sc.nextInt();
		map = new int[N][N];
		nowR = N / 2;
		nowC = N / 2;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 처음 흩날린거 확인하기

		// 이동하기
		int d = 0;
		int len = 1;
		int count = 2;

		while (move < N * N) {
			if (count > 0) {
				for (int i = 0; i < len; i++) {
					nowR += dr[d];
					nowC += dc[d];

					// 모래 흩뿌리는 메서드
//					map[nowR][nowC] = -1;
//					System.out.println(move);
					////////////////
					sandStorm(nowR, nowC, d, map[nowR][nowC]);
//					print();
					/////////////////
					move++;

					if (move > N * N - 1) {
						break;
					}
				}
				d = (d + 1) % 4;
				count--;
			}

			if (count == 0) {
				count = 2;
				len++;
			}
		}

		System.out.println(trash);

	}

	// 모래 흩뿌리기
	public static void sandStorm(int r, int c, int direction, int sand) {

		if (map[r][c] == 0) {
			return;
		}

		list = new ArrayList<>();
		index = -1;

		for (int d = 0; d < 4; d++) {
			int dir = (direction + d + 1) % 4;
			int nr = r;
			int nc = c;

			switch (d) {
			case 0:
				for (int i = 0; i < 2; i++) {
					nr += dr[dir];
					nc += dc[dir];

					if (i == 0) {
						list.add(map[r][c] * 7 / 100);
						index++;
						if (check(nr, nc)) {
							map[nr][nc] += list.get(index);
						} else {
							trash += list.get(index);
						}
					} else {
						list.add(map[r][c] * 2 / 100);
						index++;
						if (check(nr, nc)) {
							map[nr][nc] += list.get(index);
						} else {
							trash += list.get(index);
						}
					}
				}
				break;
				
			case 2:
				for (int i = 0; i < 2; i++) {
					nr += dr[dir];
					nc += dc[dir];

					if (i == 0) {
						list.add(map[r][c] * 7 / 100);
						index++;
						if (check(nr, nc)) {
							map[nr][nc] += list.get(index);
						} else {
							trash += list.get(index);
						}
					} else {
						list.add(map[r][c] * 2 / 100);
						index++;
						if (check(nr, nc)) {
							map[nr][nc] += list.get(index);
						} else {
							trash += list.get(index);
						}
					}
				}
				break;
			case 1:
				break;
			default:
				nr += (dr[dir] * 2);
				nc += (dc[dir] * 2);

				list.add(map[r][c] * 5 / 100);
				index++;
				if (check(nr, nc)) {
					map[nr][nc] += list.get(index);
				} else {
					trash += list.get(index);
				}
				break;
			}
		}

		switch (direction) {
		case 0:
			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r - 1, c - 1)) {
				map[r - 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r + 1, c - 1)) {
				map[r + 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r + 1, c + 1)) {
				map[r + 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r - 1, c + 1)) {
				map[r - 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			break;

		case 1:
			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r + 1, c - 1)) {
				map[r + 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r + 1, c + 1)) {
				map[r + 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r - 1, c - 1)) {
				map[r - 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r - 1, c + 1)) {
				map[r - 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			break;
		case 2:
			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r - 1, c + 1)) {
				map[r - 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r + 1, c + 1)) {
				map[r + 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r - 1, c - 1)) {
				map[r - 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r + 1, c - 1)) {
				map[r + 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			break;
		default:
			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r - 1, c - 1)) {
				map[r - 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 10 / 100);
			index++;

			if (check(r - 1, c + 1)) {
				map[r - 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r + 1, c - 1)) {
				map[r + 1][c - 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			list.add(map[r][c] * 1 / 100);
			index++;

			if (check(r + 1, c + 1)) {
				map[r + 1][c + 1] += list.get(index);
			} else {
				trash += list.get(index);
			}

			break;
		}

//		System.out.println(list.size());

//		System.out.println(sum);

		for (int i = 0; i < list.size(); i++) {
			map[r][c] -= list.get(i);
		}

//		System.out.println(list);

		if (check(r + dr[direction], c + dc[direction])) {
			map[r + dr[direction]][c + dc[direction]] += map[r][c];
		} else {
			trash += map[r][c];
		}

		map[r][c] = 0;
	}

	// 디버깅
	public static void print() {
		System.out.println("-------------------------------");
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
	}

	// 경계조건 체크 함수
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}