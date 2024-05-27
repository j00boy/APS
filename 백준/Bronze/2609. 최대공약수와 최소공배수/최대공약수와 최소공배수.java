import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int max = Math.max(A, B);
		int min = Math.min(A, B);
		
		int tmpA = A;
		int tmpB = B;
		
		int GCD = 987654321;	// 최대공배수
		int GCM = 0;			// 최소공약수
		
		
		for(int i = 1; i <= max; i++) {
			if(A % i == 0 && B % i == 0) {
				GCD = i;
			}
		}
		
		System.out.println(GCD);

		int cnt = 1;
		while(true) {
			if((max*cnt) % min == 0) {
				GCM = max * cnt;
				break;
			}
			cnt++;
		}
		
		System.out.println(GCM);
	}
}
