import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] D;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 수열의 길이
		arr = new int[N];	// 수열 
		D = new int[N];		// 내가 가질 수 있는 최고 순위?
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		D[0] = 1;
		if(N == 1) {
			System.out.println(1);
			return;
		}
		for(int i = 1; i < N; i++) {
			int tmp = 0;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {		// 나보다 작은 게 있으면
					if(tmp < D[j]) {		// 그때는 D[i]와 D[j]값을 비교
						tmp = D[j];			// tmp를 최댓값으로 계속 갱신해서 나아감
					}		
				}
			}
			D[i] = tmp + 1;
			if(max < D[i]) {
				max = D[i];
			}
		}
		
//		System.out.println(Arrays.toString(D));
		System.out.println(max);
	}
}