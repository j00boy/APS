import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;		// 수빈이
	static int K;		// 수빈이 동생
	static int[] road;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		road = new int[100001];

		N = sc.nextInt();
		K = sc.nextInt();
		
		BFS(N);
		
		System.out.println(road[K]);
		
		
		
	}
	
	public static void BFS(int start) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		road[start] = 0;
		
		while(!queue.isEmpty()) {
			
			int num = queue.poll();
			
			int[] arr = {num-1, num+1, num*2};
			
			for(int i : arr) {
				if(i == start) {
					continue;
				}
				if(i >= 0 && i <= 100000 && road[i] == 0) {
					queue.add(i);
					road[i] = road[num]+1;
				}
			}
		}
	}
}