import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			list.get(A).add(B);
			list.get(B).add(A);
		}
		
		DFS(1);
		System.out.println(count);
	}
	
	public static void DFS(int root) {
		if(visited[root]) {
			return;
		}
		
		visited[root] = true;	// 해당 노드부터 방문
		
		for(int i : list.get(root)) {
			if(!visited[i]) {	// 방문 안했다면 내려가서 DFS
				DFS(i);
				count++;
			}
		}
	}
	
}