import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		result = new int[M];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		combination(0, 0);
		
		System.out.println(sb);
	}
	
	public static void combination(int idx, int sidx) {
		if(sidx >= M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		result[sidx] = arr[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);
	}
}
