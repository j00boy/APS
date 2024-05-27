import java.util.Scanner;

public class Main {

	static int N;
	static long[] DP;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DP = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				DP[i] = 1;

			} else if (i == 2) {
				DP[i] = 2;
			} else {
				DP[i] = DP[i - 1] + DP[i - 2];
				DP[i] %= 10007;
			}
		}

		System.out.println(DP[N]);
	}
}
