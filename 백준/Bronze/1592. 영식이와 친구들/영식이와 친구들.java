import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
										// 0 1 2 3 4
		int N = sc.nextInt();			// 1 2 3 4 5
		int M = sc.nextInt();			// M번 받으면 => 3
		int L = sc.nextInt();			// L번째 사람에게 옮김 => 2
		
		int[] arr = new int[N];
		
		int idx = 1;
		arr[idx] = 1;
		int count = 0;
		
		boolean isValid = true;
		while(isValid) {
			if(arr[idx] == M) {
				isValid = false;
				break;
			}
			
			if(arr[idx] % 2 == 1) {		// 홀수라면 시계방향
				idx = (idx + L) % N;
				arr[idx]++;
				count++;
			} else {					// 짝수라면 반시계 방향
				idx = (idx + (N-L)) % N;
				arr[idx]++;
				count++;
			}
		}
		
		if(!isValid) System.out.println(count);
			
		
	}
}