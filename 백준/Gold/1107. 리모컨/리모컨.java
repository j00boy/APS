import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static List<Integer> wrong;
	static int minCnt = Integer.MAX_VALUE;
	static int subin = 100;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		wrong = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			wrong.add(sc.nextInt());
		}
		
		if(Math.abs(N-subin) <= String.valueOf(N).length()) {
			System.out.println(Math.abs(N-subin));
			return;
		}

		int tmp = N;
		
		// 이상의 경우 찾기
		while(true) {
			if(String.valueOf(tmp).length() + Math.abs(tmp - N) >= Math.abs(N-subin)) {
				break;
			}
			boolean flag = true;
			for(int i : wrong) {
				if(String.valueOf(tmp).contains("" + i)) {
					flag = false;
					break;
				}
			}
			
			if(flag) break;
			tmp++;
		}
		
//		System.out.println(tmp);
		minCnt = Math.min(minCnt, String.valueOf(tmp).length() + Math.abs(tmp - N));

		
		// 이하의 경우 찾기
		tmp = N;
		while(true) {
			if(String.valueOf(tmp).length() + Math.abs(tmp - N) >= Math.abs(N-subin)) {
				break;
			}
			tmp--;
			boolean flag = true;
			for(int i : wrong) {
				if(String.valueOf(tmp).contains("" + i)) {
					flag = false;
					break;
				}
			}
			
			if(String.valueOf(tmp).length() + Math.abs(tmp - N) >= Math.abs(N-subin)) {
				break;
			}
			
			if(flag) break;
		}
		
		minCnt = Math.min(minCnt, String.valueOf(tmp).length() + Math.abs(tmp - N));
//		System.out.println(tmp);
		
		System.out.println(minCnt);
	}
}