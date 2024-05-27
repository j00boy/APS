import java.util.Scanner;

public class Main {
	
	static int[] nums;
	static int K;
	static int[] S;
	static int[] sel = new int[6];
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			sb = new StringBuilder();
			K = sc.nextInt();
			
			if(K == 0) {
				break;
			}
			
			S = new int[K];
			
			for(int i = 0; i < K; i++) {
				S[i] = sc.nextInt();
			}
			
			// 어차피 오름차순으로 주어지니까 정렬할 필요가 없다.

			lotto(0, 0);
			
			System.out.println(sb);
			
		}
	}
	
	public static void lotto(int start, int idx) {	// start : 시작점, idx : 내가 선택할 숫자들의 index
		if(idx == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		if(start == K) {
			return;
		}
		
		
		for(int i = start; i < K; i++) {
			sel[idx] = S[i];
			lotto(i + 1, idx + 1);
		}
	}
	
}