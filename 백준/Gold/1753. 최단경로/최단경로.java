import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();	// 간선의 개수가 20000까지라서, 한번에 출력하기 위한 StringBuilder
	
	static class Edge implements Comparable<Edge> {
		int end;
		int w;
		
		public Edge(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;	// 최단경로를 위해 가중치로 비교(우선순위)
		}
	}
	
	static int V;
	static int E;
	static int[] dist;
	static ArrayList<Edge>[] adjList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();			// 정점의 개수 
		E = sc.nextInt();			// 간선의 개수 
		int start = sc.nextInt();	// 시작점 정보 
		
		// 최단거리 갱신배열 초기화 
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		// 인접리스트 초기화
		adjList = new ArrayList[V+1];
		for(int i = 0; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선정보 입력 받기
		for(int i = 0; i < E; i++) {
			adjList[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		dijkstra(start);
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		
		boolean[] visited = new boolean[V+1];
		
		pq.add(new Edge(start, dist[start]));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.end]) {
				continue;
			}
			
			visited[curr.end] = true;
			
			for(Edge edge : adjList[curr.end]) {
				if(!visited[edge.end] && dist[edge.end] > dist[curr.end] + edge.w) {
					dist[edge.end] = dist[curr.end] + edge.w;
					pq.add(new Edge(edge.end, dist[edge.end]));
				}
			}
		}
	}
}