import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] local;
	static int budget;
	static int left;
	static int right;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		local = new int[N];
		
		int max = 0;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			local[i] = sc.nextInt();
			sum += local[i];
			max = Math.max(max, local[i]);
		}
		
		budget = sc.nextInt();
		
		if(sum <= budget) {
			System.out.println(max);
		} else {
			
			left = 1;
			right = max;
			
			while(left <= right) {
				int tmp = 0;
				int mid = (left + right) / 2;						// mid는 정수 상한액
//				System.out.println(mid);
				
				for(int i = 0; i < N; i++) {
					if(local[i] < mid) {							// 예산요청 <= 상한액
						tmp += local[i];
					} else if(local[i] >= mid) {					// 예산요청 > 상한액
						tmp += mid;
					}
				}
				
				if(tmp <= budget) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
				
			}
			
			int fuck = left - 1;
//			System.out.println(fuck);
			
			max = 0;
			for(int i = 0; i < N; i++) {
				if (local[i] >= fuck){
					local[i] = fuck;
				}
				max = Math.max(max, local[i]);
			}
			
//			System.out.println(Arrays.toString(local));
			
			System.out.println(max);
		}
		
	}
}
