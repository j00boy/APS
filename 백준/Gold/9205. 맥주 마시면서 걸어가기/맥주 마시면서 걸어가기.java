import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[] home;
	static int cvsCnt;
	static ArrayList<int[]> list;
	static int beer;
	static int[] festival;
	static int[][] map;
	static boolean[] visited;
	static String answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			list = new ArrayList<>();
			
			cvsCnt = sc.nextInt();
			home = new int[] {sc.nextInt(), sc.nextInt()};
			
			list.add(home);
			
			for(int i = 0; i < cvsCnt; i++) {
				list.add(new int[] {sc.nextInt(), sc.nextInt()});
			}
			
			
			festival = new int[] {sc.nextInt(), sc.nextInt()};
			
			list.add(festival);
			
			BFS(home[0], home[1]);
			
			if(!visited[list.size()-1]) {
				System.out.println("sad");
			} else {
				System.out.println("happy");
			}
		}
		// test case
	}
	
	public static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		visited = new boolean[list.size()];
		
		visited[0] = true;

		queue.add(new int[] {r, c});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i = 0; i < list.size(); i++) {
				if(Math.abs(list.get(i)[0] - now[0]) + Math.abs(list.get(i)[1] - now[1]) <= 1000 && !visited[i]) {
					visited[i] = true;
					queue.add(list.get(i));
				}
			}
		}
	}

	public static boolean check(int r, int c) {
		return r >= 0 && c >= 0 && r <= festival[0] && c <= festival[1];
	}
}
