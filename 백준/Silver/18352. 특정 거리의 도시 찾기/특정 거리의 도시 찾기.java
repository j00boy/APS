import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int end;
	int w;
	
	public Node (int end, int w) {
		this.end = end;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
	
}

public class Main {

	static int N;
	static int M;
	static int K;
	static int X;
	static ArrayList<Node>[] adjList;
	static int[] D;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 도시의 개수 (정점)
		M = sc.nextInt(); // 도로의 개수 (간선)
		K = sc.nextInt(); // 거리 정보
		X = sc.nextInt(); // 도시 출발 번호

		// 인접행렬 초기화
		adjList = new ArrayList[N + 1];
		D = new int[N+1];

		for (int i = 0; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 입력 to 인접리스트
		for (int i = 0; i < M; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), 1));
		}
		
		Arrays.fill(D, 987654321);
		
		dijkstra(X);
		
		int count = 0;
		for(int i = 0; i <= N; i++) {
			if(D[i] == K) {
				sb.append(i + "\n");
				count++;
			}
		}
		
		if(count == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}
		
	}

	public static void dijkstra(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();

		boolean[] visited = new boolean[N + 1];
		
		D[start] = 0;

		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(visited[curr.end]) {
				continue;
			}
			
			visited[curr.end] = true;
			for(Node node : adjList[curr.end]) {
				if(!visited[node.end] && D[node.end] > D[curr.end] + node.w) {
					D[node.end] = D[curr.end] + node.w;
					pq.add(new Node(node.end, D[node.end]));
				}
			}
		}
	}
}