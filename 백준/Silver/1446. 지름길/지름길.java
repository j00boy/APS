import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int dist;
		
		public Edge(int start, int end, int dist) {
			this.start = start;
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", dist=" + dist + "]";
		}


		@Override
		public int compareTo(Edge o) {
			if(this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}
	
	static int N;
	static int D;
	static ArrayList<Edge> list = new ArrayList<>();
	static boolean[] visited;
	static int[] DP;
	static int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D = sc.nextInt();
		visited = new boolean[N];
		DP = new int[N+1];
		Arrays.fill(DP, 987654321);
	
		for(int i = 0; i < N; i++) {
			list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		permutation(0);
		
		System.out.println(min);
		
	}
	
	public static void permutation(int idx) {
		if(idx >= N) {
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					pq.add(list.get(i));
				}
			}
			
			int len = 0;
			int end = 0;
			while(!pq.isEmpty()) {
				Edge curr = pq.poll();
				if(curr.start < end || curr.end > D) {
					return;
				}
				
				if(curr.start >= end) {
					len += (curr.start-end) + curr.dist;
					end = curr.end;
				}
			}
			
			len = len + (D-end);
			min = Math.min(min, len);
			return;
		}
		
		visited[idx] = true;
		permutation(idx + 1);
		visited[idx] = false;
		permutation(idx + 1);
	}
	
}