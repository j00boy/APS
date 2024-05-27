import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int nums[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[M];

		comb(1, 0);

		System.out.println(sb);
	}

	public static void comb(int start, int idx) {
		if (idx >= M) {
			for (int i = 0; i < M; i++) {
				sb.append(nums[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			nums[idx] = i;
			comb(i, idx+1);
		}
	}
}
