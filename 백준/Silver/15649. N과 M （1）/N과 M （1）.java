import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] sel;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		visited = new boolean[N];
		sel = new int[M];
		
		for(int i = 1; i <= N; i++) {
			nums[i-1] = i;
		}
		
		// 재귀 코드
		perm(0);
		
	}
	
	static void perm(int idx) {
		if(idx >= M) {
			for(int i = 0; i < M; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			
			sel[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
	
}
