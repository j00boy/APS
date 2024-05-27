import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int V;
	static int E;
	static int[] p;
	static int[][] edges;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		// 유니온파인드 배열 생성 및 초기화
		p = new int[V+1];
		for(int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		edges = new int[E][3];	// 양 쪽 정점, 가중치
		
		for(int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int count = 0;
		int W = 0;
		
		for(int i = 0; i < E; i++) {
			int px = findParent(edges[i][0]);
			int py = findParent(edges[i][1]);
			
			if(px != py) {
				union(px, py);
				count++;
				W += edges[i][2];
			}
			
			if(count == V-1) {
				System.out.println(W);
				break;
			}
		}
	}
	
	public static int findParent(int num) {
		if(num != p[num]) {
			p[num] = findParent(p[num]);
		}
		return p[num];
	}
	
	public static void union(int a, int b) {
		p[b] = a;
	}
}