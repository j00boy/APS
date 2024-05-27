import java.util.Scanner;

public class Main {

	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int n = 4 * N - 3;
		map = new char[n][n];

		// 배열 값의 초기화를 안해주면 틀리는 것 같음;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				map[i][j] = '\u0000';
//			}
//		}
		printStars(0, n);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '*') {
					System.out.print(map[i][j]);
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}

	public static void printStars(int start, int end) { // parameter: 시작점, 끝점
		if (start >= end) {
			return; // 함수 종료(자기 자신을 부르는 것을 종료한다.
		}

		for (int i = start; i < end; i++) {
			map[start][i] = '*'; // 윗변
			map[i][start] = '*'; // 왼쪽변
			map[i][end - 1] = '*'; // 오른변
			map[end - 1][i] = '*'; // 아랫변
		}

		start += 2;
		end -= 2;
		printStars(start, end);
	}
}