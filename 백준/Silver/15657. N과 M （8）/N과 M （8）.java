import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] arr;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[M];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx >= M) {
			for(int i = 0; i < M; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < N; i++) {
			sel[sidx] = arr[i];
			comb(i, sidx + 1);
		}
	}
}
