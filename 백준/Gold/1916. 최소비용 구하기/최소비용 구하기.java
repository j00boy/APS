import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int M;
	static int[] dist;
	static ArrayList<Node>[] adjList;
	
	// 가중치 저장을 위한 static class 생성 
	static class Node implements Comparable<Node> {
		int end;
		int w;
		
		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();	// 도시의 개수 
		M = sc.nextInt();	// 간선의 개수 
		
		// 거리 저장 배열을 충분히 큰 값으로 초기화 
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		// 인접리스트 생성 및 초기화 
		adjList = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선 정보 입력 
		for(int i = 0; i < M; i++) {
			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		
		// 시작 지점, 도착 지점 
		int start = sc.nextInt();
		int departure = sc.nextInt();
		
		dijkstra(start);
		
		System.out.println(dist[departure]);
		
//		System.out.println(Arrays.toString(dist));

	}
	
	public static void dijkstra(int start) {
		
		// 우선순위 큐 생성 (최소비용을 위해)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		// 방문체크 배열 
		boolean[] visited = new boolean[N+1];
		
		// 여기서 시작할 거니까 from 시작점 to 시작점까지의 최단거리 = 0
		dist[start] = 0;
		
		// 시작하는 노드와 최단거리를 pq에 넣음 
		pq.add(new Node(start, dist[start]));
		
		// pq가 빌 때까지 
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			// 현재 노드 방문 체크 
			if(visited[curr.end]) {
				continue;
			}
			
			// 방문한 적이 없다면, 방문처리 
			visited[curr.end] = true;
			// 현재노드와 인접한 노드들 중에서 
			for(Node node : adjList[curr.end]) {
				// 방문한 적 없고, 인접노드까지의 최단거리 > 현재노드까지의 최단거리 + from 현재노드 to 인접노드까지의 거리라면
				if(!visited[node.end] && dist[node.end] > dist[curr.end] + node.w) {
					// 최단거리 갱신 및 pq에 추가 
					dist[node.end] = dist[curr.end] + node.w;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		
	}

}