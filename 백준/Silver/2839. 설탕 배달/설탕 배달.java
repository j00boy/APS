import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int result = 0;		// 정답을 담을 변수 
		int count_3 = 0;	// 3짜리 봉지의 갯수 
		int count_5 = 0;	// 5짜리 봉지의 갯수 
		
		boolean flag = true;	// while문 탈출을 위한 flag
		// 만약에 N이 0보다 작아진다면, 3을 아무리 추가해도 3과 5로 딱 떨어지는 무게를 맞출 수 없음을 뜻함
		
		while(flag) {
			if(N < 0) {
				result = -1;
				flag = false;
				break;
			}
			
			if(N % 5 == 0) {				// N이 5(가장 큰 단위)로 나누어 떨어진다면 
				count_5 = N / 5;			// 5의 갯수 
				result = count_5 + count_3;	// 5짜리 봉지 + 3짜리 봉지 
				break;
			} else {
				N -= 3;						// 나누어 떨어지지 않는다면, 3(작은 단위)을 하나 추가하고 다시 반복 
				count_3++;
			}
		}
		
		System.out.println(result);
		
	}
}