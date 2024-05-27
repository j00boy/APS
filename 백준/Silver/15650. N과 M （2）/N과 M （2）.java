import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		sel = new int[M];
		for(int i = 1; i <= N; i++) {
			nums[i-1] = i;
		}
		
		comb(0, 0);
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx >= M) {
			for(int i = 0; i < M; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		sel[sidx] = nums[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}
