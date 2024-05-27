import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int V;
	static ArrayList<ArrayList<Integer>> 인접리스트 = new ArrayList<>();
	static boolean[] visited;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static String ans = "";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 정점의 개수
		M = sc.nextInt();	// 간선의 개수
		V = sc.nextInt();	// 탐색 시작할 정점의 번호

		// 인접리스트 초기화
		for(int i = 0; i < N+1; i++) {
			인접리스트.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			인접리스트.get(A).add(B);
			인접리스트.get(B).add(A);
		}
		
		// 선 정렬
		for(int i = 0; i < N+1; i++) {
			Collections.sort(인접리스트.get(i));
		}

		// DFS
		visited = new boolean[N+1];
		ans += V;
		DFS(V);
		System.out.println(ans);
		
		
		// BFS
		visited = new boolean[N+1];
		ans = "";
		queue.add(V);
		visited[V] = true;
		BFS(V);
		System.out.println(ans);
		
	}
	
	public static void DFS(int root) {
		if(visited[root]) {
			return;
		}
		
		visited[root] = true;
		
		for(int i : 인접리스트.get(root)) {
			if(!visited[i]) {
				ans += " " + i;
				DFS(i);
			}
		}
	}
	
	public static void BFS(int root) {
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			ans += idx + " ";
			for(int i : 인접리스트.get(idx)) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}

	}

}