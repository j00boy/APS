import java.util.Scanner;

public class Main {
	
	static int start;		// 1번 막대기
	static int middle;		// 2번 막대기
	static int end;			// 3번 막대기
	static long count = 0;	// 연산 횟수
	static StringBuilder ans = new StringBuilder("");	// 시간 초과로 인한 StringBuilder
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		moving(N, 1, 2, 3);
		System.out.println(count);
		System.out.println(ans);
	}
	/*
	 * N >= 2일 때,
	 * D[N] = D[N-1] + 1 + D[N-1] = 2 * D[N-1] + 1
	 * 
	 * 'N'의 크기를 가진 원반이 3번 막대기의 밑으로 가기 위해서는
	 * 'N-1'개의 원반이 2번 막대로 옮겨져야 함 => D[N-1]
	 * 'N' 크기의 원반이 3번 막대로 옮겨져야 함 => count++
	 * 2번 막대에 있는 N-1개의 원반들이 전부 3번 막대로 옮겨져야 함 => D[N-1]
	 * D[N] = 2*D[N-1] + 1
	 * ...
	 * ...
	 * ...
	 * D[2] = 2*D[1] + 1
	 * D[1] = 1
	 */
	
	// start: 1번 막대, middle: 2번 막대, end: 3번 막대
	// start: 움직임이 시작될 막대기, end: 목적지, middle: 목적지에 가기 위한 경유지 
	public static void moving(int N, int start, int middle, int end) {
		if(N == 1) {
			count ++;								// N=1일 때, count++
			ans.append(start + " " + end + "\n");	// String이 시간 초과, StringBuilder 사용
			return;		// 함수 종료
		}
		moving(N-1, start, end, middle);	// start에 있는 N-1개의 원반을 middled이라는 종착지에 옮기기
		moving(1, start, middle, end);		// 'N' 크기의 원반을 end로 옮기기
		moving(N-1, middle, start, end);	// N-1개의 원반이 있는 2번 막대에서 3번 막대로 옮기기
	}
	
}