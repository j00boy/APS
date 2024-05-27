/*
 * 1트: 부분수열이 연속되지 않아도 되는 경우로 생각하였음
 */
import java.util.Scanner;

public class Main {
	
	static int N;	// 주어지는 정수의 갯수 
	static int S;	// 목표 합
	static int count = 0;
	static int[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		S = sc.nextInt();
		
		nums = new int[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		powerSet(0);
		
		// -1을 해주는 이유는 아무것도 안 고르는 공집합의 부분집합이 있기 때문에
		if(S ==0) {
			System.out.println(count - 1);
		} else {
			System.out.println(count);
		}
		
	}
	
	public static void powerSet(int idx) {
		if(idx == nums.length) {
			int sum = 0;
			for(int i = 0; i < nums.length; i++) {
				if(visited[i]) {
					sum += nums[i];
				}
			}
			if(sum == S) {
				count++;
			}
			return;
		}
		
		visited[idx] = false;
		powerSet(idx + 1);
		visited[idx] = true;
		powerSet(idx + 1);
	}
}