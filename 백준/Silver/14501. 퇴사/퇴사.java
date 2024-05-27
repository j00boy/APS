import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] D1;
	static int[] D2;
	static int[] T;
	static int[] P;
	static int dDay;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		D1 = new int[N+2];	// i번째 일 ~ 퇴사일까지 벌 수 있는 최대 수입 저장 배열
		D2 = new int[N+2];	// i번째 일 ~ 퇴사일까지 벌 수 있는 최대 수입 저장 배열
		T = new int[N+1];	// i번째 일에서 상담을 하는데 필요한 일수 
		P = new int[N+1];	// i번째 일에서 상담을 완료했을 때 받는 수입
		
		dDay = N+1;
		
		for(int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i = N; i >= 1; i--) {
			if(i + T[i] > dDay) {		// i번째 상담을 퇴사일까지 완료할 수 없을 때 
				D1[i] = D1[i+1];			// D[i] = D[i+1]~퇴사일까지 벌 수 있는 최대 금액
			} else {					// 상담을 완료할 수 있다면,
				D1[i] = Math.max(D1[i+1], P[i] + D1[i + T[i]]);
			}
		}
		
		System.out.println(D1[1]);
	}
	

}
