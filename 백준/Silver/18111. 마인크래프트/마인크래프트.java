import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int B = Integer.parseInt(st1.nextToken()); // 인벤토리에 이미 있는 블록의 갯수

		int[] site = new int[N * M];

		int idx = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int j = 0; j < N; j++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				site[idx + i] = Integer.parseInt(st2.nextToken());
				if(site[idx + i] < min) {
					min = site[idx + i];
				}
				if(site[idx + i] > max) {
					max = site[idx + i];
				}
			}
			idx += M;
		}
		
		int minTime = Integer.MAX_VALUE;
		int highestBlock = 0;

		// 총 작업시간을 구하는 함수
		for (int i = min; i <= max; i++) {
			int inven = B;
			int time = 0;
			boolean flag = true;

			for (int j = 0; j < N * M; j++) {
				if(site[j] - i > 0) {
					time += 2 * (site[j] - i);
					inven += site[j] - i;
				} else {
					time += i - site[j];
					inven -= i - site[j];
				}
			}
			
			if(inven < 0) {
				flag = false;
				break;
			}
			
			if (flag == true && time <= minTime) {
				minTime = time;
				highestBlock = i;
			}
		}

		System.out.println(minTime + " " + highestBlock);

		
	}
}