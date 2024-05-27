import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int N;			// 컴퓨터 개수
	static int M;			// 네트워크선 개수
	static int[] p;			// 유니온파인드 배열
	static int[][] edges;	// 간선 입력 저장 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 유니온파인드 배열 생성 및 초기화
		p = new int[N+1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		edges = new int[M][3];	// 양 쪽 정점, 가중치
		
		for(int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		// 가중치 기준으로 내림차순
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 간선끼리 잇는 횟수
		int count = 0;
		int W = 0;		// 가중치의 합
		
		for(int i = 0; i < M; i++) {
			int px = findParent(edges[i][0]);	// 정렬된 순서대로 각 정점의 부모를 찾고
			int py = findParent(edges[i][1]);
			
			if(px != py) {		// 루트가 다르다면
				union(px, py);	// 합친다
				count++;
				W += edges[i][2];
			}
			
			if(count == N-1) {	// V-1 번 합쳐졌다는 뜻은 모든 간선이 연결되었다는 뜻
				System.out.println(W);
				break;
			}
		}
	}
	
	// 루트 노드 확인 메서드
	public static int findParent(int num) {
		if(num != p[num]) {
			p[num] = findParent(p[num]);
		}
		return p[num];
	}
	
	// 합치기 메서드
	public static void union(int a, int b) {
		p[b] = a;
	}
}