import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int All;
	static ArrayList<ArrayList<Integer>> adjList;
	static int mom;
	static int son;
	static boolean[] people;
	static int rel;
	static int chon;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		All = sc.nextInt();
		mom = sc.nextInt();
		son = sc.nextInt();
		
		adjList = new ArrayList<>();
		
		for(int i = 0; i <= All; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		people = new boolean[All + 1];
		
		rel = sc.nextInt();
		
		// 인접리스트
		for(int i = 0; i < rel; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjList.get(A).add(B);
			adjList.get(B).add(A);
		}
		
		// 여기에 관계 정의하는 메서드
		chon = -1;
		
		DFS(mom, 0);
		
		System.out.println(chon);
		
	}
	
	public static void DFS(int start, int step) {
		if(start == son) {
			chon = step;
			return;
		}
		
		people[start] = true;
		
		for(int num : adjList.get(start)) {
			if(!people[num]) {
				DFS(num, step + 1);
			}
		}
	}
}
