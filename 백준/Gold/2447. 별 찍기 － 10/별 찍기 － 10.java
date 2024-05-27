import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static String[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new String[N][N];
		for (int r = 0; r < N; r++) {
			Arrays.fill(arr[r], "*");
		}

		printStar(0, 0, N);

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(arr[r][c]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void printStar(int row, int col, int side) {
		// 기저 조건
		if (side == 1) {
			return;
		}

		// 실행 로직
		int newSide = side / 3;

		for (int r = row + newSide; r < row + newSide * 2; r++) {
			for (int c = col + newSide; c < col + newSide * 2; c++) {
				arr[r][c] = " ";
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				printStar(row + i * newSide, col + j * newSide, newSide);
			}
		}

	}

}