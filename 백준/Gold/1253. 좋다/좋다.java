import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static long[] arr;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		arr = new long[size];
		count = 0;
		
		for(int i = 0; i < size; i++) {
			arr[i] = sc.nextLong();
		}
		
		// 이분탐색 쉽게 하려고 정렬
		Arrays.sort(arr);

		for(int i = 0; i < size; i++) {
			
			int left = 0;
			int right = size - 1;
			
			/*
			 * 처음에는 left = 0, right = i-1 이라고만 생각했었다. 왜냐면 크기순으로 정렬했기 때문에.
			 * 근데 만약에 내 뒤에 있는 숫자도 나보다 같다고 한다면 예외가 발생함 -> 3% 에서 67%로 진화
			 */
			
			while(left < right) {
				
				long sum = arr[left] + arr[right];
				
				if(sum == arr[i]) {
					if(left != i && right != i) {
						count++;
						break;						
					} else if(left == i) {
						left++;
					} else if(right == i) {
						right--;
					}
				} else if(sum < arr[i]) {
					left++;
				} else {
					right--;
				}
					
			}
		}
		
		System.out.println(count);
		
	}
}