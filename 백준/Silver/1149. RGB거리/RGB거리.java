import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] rgb;
	static int[][] D;

	// DP 풀이 방식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rgb = new int[N][3];
		D = new int[N][3];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				if(r == 0) {
					rgb[r][c] = Integer.parseInt(st.nextToken());
					D[r][c] = rgb[r][c];
				} else {
					rgb[r][c] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		

		for (int r = 1; r < N; r++) {
			D[r][0] = Math.min(D[r - 1][1] + rgb[r][0], D[r - 1][2] + rgb[r][0]);
			D[r][1] = Math.min(D[r - 1][0] + rgb[r][1], D[r - 1][2] + rgb[r][1]);
			D[r][2] = Math.min(D[r - 1][0] + rgb[r][2], D[r - 1][1] + rgb[r][2]);
		}


		System.out.println(Math.min(Math.min(D[N-1][0], D[N-1][1]), D[N-1][2]));
	}

}
