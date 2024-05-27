import java.util.Scanner;

public class Main {

	static int[][] paper;	// 첫 종이
	// 같은 숫자일 경우 종이의 개수: -1, 0, 1
	static int minusOne = 0;
	static int zero = 0;
	static int plusOne = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		paper = new int[N][N];
		
		// 숫자 입력
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}
		
		cutPaper(0, 0, N);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
		
	}

	// 종이 1개에 대한 check
	public static boolean checkIsSame(int r, int c, int N) {
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (paper[r][c] != paper[i][j]) {	// 같은 숫자가 아니라면 false;
					return false;
				}
			}
		}
		return true;	// 전부 같으면 true;
	}

	public static void cutPaper(int r, int c, int N) {
		if (checkIsSame(r, c, N)) {		// 숫자가 같다면 어떤 종이의 숫자를 올릴지 선택
			if (paper[r][c] == -1) {
				minusOne++;
			} else if (paper[r][c] == 0) {
				zero++;
			} else if (paper[r][c] == 1) {
				plusOne++;
			}
			return;						// 함수 종료
			
		} else {
			int new_N = N / 3;			// 종이의 변을 3으로 나눔

			for (int i = r; i < r + N; i += new_N) {		// new_N만큼 증감식
				for (int j = c; j < c + N; j += new_N) {	// new_N만큼 증감식
					cutPaper(i, j, new_N);					// 9개로 나눈 종이에 대해 cutPaper() 메서드를 실행
				}											// 1 by 1인 종이가 되면 checkisSame() 함수에서 종료됨
			}
		}
	}

}