/*
 * 1. 선거구 단순하게 나누기
 * - 2^10 = 1024이므로 가능할 것 같음
 * 2. 각 선거구끼리 연결되어 있는지 확인하기
 * - BFS 사용하면 될 듯함
 * 3. - 1, 2번 만족 시 인구 차 구하기
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static boolean[] connected;
	static int[] population;
	static int gap = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		connected = new boolean[N+1];
		population = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			population[i] = sc.nextInt();
		}
		
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			int n = sc.nextInt();
			for(int j = 0; j < n; j++) {
				adjList[i].add(sc.nextInt());
			}
		}
		
		permutation(1);
		
		if(gap == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(gap);			
		}
		
	}
	// 조합 나누기 (순열)
	static void permutation(int idx) {
		if(idx >= N+1) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			for(int i = 1; i <= N; i++) {
				if(visited[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			
			// A나 B가 빈거면 종료
			if(A.isEmpty() || B.isEmpty()) {
				return;
			}
			
			// 연결 확인
			connected = new boolean[N+1];
			DFS(A.get(0), A);
			for(int i : A) {
				// 방문안된게 하나라도 있다면 종료
				if(!connected[i]) {
					return;
				}
			}
			
			
			connected = new boolean[N+1];
			DFS(B.get(0), B);
			for(int i : B) {
				// 방문안된게 하나라도 있다면 종료
				if(!connected[i]) {
					return;
				}
			}
			
			int diff = Math.abs(getCount(A) - getCount(B));
			gap = Math.min(gap, diff);
			
			return;
		}
		
		visited[idx] = true;
		permutation(idx+1);
		visited[idx] = false;
		permutation(idx+1);
	}
	
	// 연결되어있는지 확인하기
	public static void DFS(int num, ArrayList<Integer> list) {
		connected[num] = true;
		for(int i : adjList[num]) {
			if(!connected[i] && list.contains(i)) {
				DFS(i, list);
			}
		}
		
	}
	
	public static int getCount(ArrayList<Integer> list) {
		int sum = 0;
		for(int i : list) {
			sum += population[i];
		}
		
		return sum;
	}
}