import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int root = 1;
	static int N;
	static int[] parents;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> 인접리스트 = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		parents = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N+1; i++) {
			인접리스트.add(new ArrayList<Integer>());	// 배열 안에 배열이기 떄문에, element 초기화
		}

		for (int i = 2; i <= N; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			인접리스트.get(A).add(B);
			인접리스트.get(B).add(A);
		}
		
//		System.out.println(인접리스트);

		dfs(root);

		for(int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
		
	}

	public static void dfs(int node) {

		visited[node] = true;		// 방문 체크
		
		for(int i : 인접리스트.get(node)) {	// 해당 노드에 인접한 노드를 확인할 건데,
			if(!visited[i]) {				// 해당 노드를 방문한 적이 없다면
				parents[i] = node;			// 해당 노드의 부모는 나
				dfs(i);						// 또 인접행렬 있는지 확인
			}
		}

	}

}