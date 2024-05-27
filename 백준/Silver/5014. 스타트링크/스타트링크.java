import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static final String CANT = "use the stairs";
	static int F;	// 총 층수
	static int S;	// 출발지
	static int G;	// 목적지
	static int U;	// 위로 내려가는 엘레베이터
	static int D;	// 아래로 올라가는 엘레베이터
	static int[] building;
	static int buttonCnt;
	
	// 10 1 10 2 1
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		building = new int[F+1];
		Arrays.fill(building, -1);
		buttonCnt = -1;
		
		elevator(S);
		
		if(buttonCnt == -1) {
			System.out.println(CANT);
		} else {
			System.out.println(buttonCnt);
		}
		
	}
	
	public static void elevator(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		
		building[idx] = 0;
		queue.add(idx);
		
		while(!queue.isEmpty()) {
			int now_floor = queue.poll();
			
			int nIdx = now_floor + U;
			
			if(check(nIdx) && building[nIdx] == -1) {
				building[nIdx] = building[now_floor] + 1;
				queue.add(nIdx);
			}
			
			nIdx = now_floor - D;
			if(check(nIdx) && building[nIdx] == -1) {
				building[nIdx] = building[now_floor] + 1;
				queue.add(nIdx);
			}
			
			if(building[G] != -1) {
				buttonCnt = building[G];
				return;
			}
		}
	}
	
	public static boolean check(int idx) {
		return idx >= 1 && idx <= F;
	}
}
