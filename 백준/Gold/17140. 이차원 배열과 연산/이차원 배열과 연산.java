import java.util.Scanner;

public class Main {

	static int[][] A;
	static int row;
	static int col;
	static int k;
	static int[][] copied;

	static int R;
	static int C;
	static int max;
	static int min;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = 3;
		C = 3;

		row = sc.nextInt();
		col = sc.nextInt();
		k = sc.nextInt();

		copied = new int[100][100];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				copied[r][c] = sc.nextInt();
			}
		}

		min = 0;
		flag = true;
		while (flag) {
			if (min > 100) {
				min = -1;
				flag = false;
				break;
			}

			if (copied[row - 1][col - 1] == k) {
				flag = false;
				break;
			}

			if (R >= C) {
				cal_R();
//				for (int r = 0; r < 100; r++) {
//					for (int c = 0; c < 100; c++) {
//						System.out.print(copied[r][c] + " ");
//					}
//					System.out.println();
//				}
			} else {
				cal_C();
//				for (int r = 0; r < 100; r++) {
//					for (int c = 0; c < 100; c++) {
//						System.out.print(copied[r][c] + " ");
//					}
//					System.out.println();
//				}
			}
		}

		System.out.println(min);
	}

	// 행 연산
	public static void cal_R() {
		A = new int[100][100];
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				A[r][c] = copied[r][c];
			}
		}

		max = 0;
		copied = new int[100][100];

		for (int r = 0; r < 100; r++) {
			int[] counts = new int[101];
			for (int c = 0; c < 100; c++) {
				counts[A[r][c]]++;
			}

			int idx = 0;
			int cnt = 1;
			while (cnt <= 100) {
				for (int c = 1; c <= 100; c++) {
					if (counts[c] == cnt) {
						copied[r][idx++] = c;
						copied[r][idx++] = counts[c];
					} else {
						continue;
					}
				}
				cnt++;
			}
			max = Math.max(max, idx);
		}

		if (max > 100) {
			C = 100;
		} else {
			C = max;
		}
//		System.out.println("C :" + C);
		min++;
//		System.out.println(min);
	}

	// 열 연산
	public static void cal_C() {
		A = new int[100][100];
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				A[r][c] = copied[r][c];
			}
		}

		max = 0;
		copied = new int[100][100];
		for (int c = 0; c < 100; c++) {
			int[] counts = new int[101];
			for (int r = 0; r < 100; r++) {
				counts[A[r][c]]++;
			}

			int idx = 0;
			int cnt = 1;
			while (cnt <= C) {
				for (int r = 1; r < 101; r++) {
					if (counts[r] == cnt) {
						copied[idx++][c] = r;
						copied[idx++][c] = counts[r];
					}
				}
				cnt++;
			}
			max = Math.max(max, idx);
		}

		if (max > 100) {
			R = 100;
		} else {
			R = max;
		}

//		System.out.println("R :" + R);
		min++;
//		System.out.println(min);
	}
}
