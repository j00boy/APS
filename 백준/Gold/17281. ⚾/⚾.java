import java.util.Scanner;

public class Main {

	static boolean[] map;
	static int inning; // 이닝 수
	static int[] twins; // 팀
	static int[][] score;
	static boolean[] number;
	static int maxScore;
	static int index;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new boolean[3];
		twins = new int[9];
		number = new boolean[9];
		number[3] = true;
		twins[3] = 0;
		inning = sc.nextInt();
		score = new int[inning][9];
		maxScore = 0;

		for (int r = 0; r < inning; r++) {
			for (int c = 0; c < 9; c++) {
				score[r][c] = sc.nextInt();
			}
		}

		// 0번 index 선수는 이미 골라짐
		permutation(1);

		System.out.println(maxScore);

	}

	// 타순을 구하는 함수
	public static void permutation(int idx) {
		if (idx >= 9) {
//			System.out.println(Arrays.toString(twins));
			index = 0;
			playBall();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (number[i]) {
				continue;
			}

			number[i] = true;
			twins[i] = idx;
			permutation(idx + 1);
			number[i] = false;
		}
	}

	public static void playBall() {
		int sum = 0;

		for (int r = 0; r < inning; r++) {
			map = new boolean[3];
			int outCnt = 0;

			while (outCnt < 3) {
				int hit = score[r][twins[index]];
				if (hit == 0) {
					outCnt++;
					index = (index + 1) % 9;
					continue;
				} else if (hit == 1) {
					if (map[2]) {
						map[2] = false;
						sum += 1;
					}
					for (int i = 1; i >= 0; i--) {
						if (map[i]) {
							map[i] = false;
							map[i + 1] = true;
						}
					}
					map[0] = true;
					index = (index + 1) % 9;
					continue;
				} else if (hit == 2) {
					for (int i = 2; i >= 1; i--) {
						if (map[i]) {
							map[2] = false;
							sum += 1;
						}
					}
					map[1] = true;
					if (map[0]) {
						map[0] = false;
						map[2] = true;
					}
					index = (index + 1) % 9;
					continue;
				} else if (hit == 3) {
					for (int i = 0; i < 3; i++) {
						if (map[i]) {
							map[i] = false;
							sum += 1;
						}
					}
					map[2] = true;
					index = (index + 1) % 9;
					continue;
				} else {
					for (int i = 0; i < 3; i++) {
						if (map[i]) {
							map[i] = false;
							sum += 1;
						}
					}
					sum += 1;
					index = (index + 1) % 9;
					continue;
				}
			}
		}

		maxScore = Math.max(sum, maxScore);
	}
}
