import java.util.Scanner;

public class Main {

	static int N;
	static int[][] adj;
	static int[] start;
	static int[] link;
	static boolean[] visited;
	static int minGap = Integer.MAX_VALUE;
	static int total = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		start = new int[N / 2];
		link = new int[N / 2];
		adj = new int[N][N];
		visited = new boolean[N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				adj[r][c] = sc.nextInt();
				total += adj[r][c];
			}
		}

		comb(0, 0);

		System.out.println(minGap);
	}

	public static void comb(int idx, int sidx) {
		if (sidx >= N/2) {
			int index_s = 0;
			int index_l = 0;
			for(int i = 0; i < N; i++) {
				if(!visited[i]) {
					link[index_l++] = i;
				} else {
					start[index_s++] = i;
				}
			}
//			System.out.println(Arrays.toString(start));
//			System.out.println(Arrays.toString(link));
			int gap = teamWork();
			minGap = Math.min(gap, minGap);
			return;
		}

		if (idx >= N) {
			return;
		}

		visited[idx] = true;
		comb(idx + 1, sidx + 1);
		visited[idx] = false;
		comb(idx + 1, sidx);
	}

	public static int teamWork() {
		int sum_s = 0;
		int sum_l = 0;
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				sum_s += adj[start[i]][start[j]];
				sum_l += adj[link[i]][link[j]];
			}
		}

		return Math.abs(sum_s - sum_l);
	}
}
