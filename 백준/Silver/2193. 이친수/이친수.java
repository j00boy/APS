import java.util.Scanner;

public class Main {

	static int N;
	static long[] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		D = new long[N + 1];

		// bottom-UP 방식

		for (int i = 1; i <= N; i++) {
			if (i == 1 || i == 2) {
				D[i] = 1;
			}
			if (i >= 3) {
				D[i] = D[i - 1] + D[i - 2];
			}
		}

		System.out.println(D[N]);

	}
}
