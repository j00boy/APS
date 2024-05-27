import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			list.get(A).add(B);
			list.get(B).add(A);
		}
		
		int count = 0;
		
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				BFS(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(Node);
		visited[Node] = true;
		
		while(!queue.isEmpty()) {
			int now_Node = queue.poll();
			for(int i : list.get(now_Node)) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

}