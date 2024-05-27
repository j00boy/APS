import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// selectionsort 구현했으나 시간초과..
		Arrays.sort(arr);

		int min = 0;
		int max = arr[arr.length - 1];
		
		while (min <= max) {
			int median = (min + max) / 2;
			
			long branchesSum = 0;
			for (int i = 0; i <= arr.length-1; i++) {
				if (arr[i] - median >= 0) {
					branchesSum += arr[i] - median;
				}
			}
			
			if(branchesSum >= M) {
				min = median + 1;
			} else {
				max = median - 1;
			}
		}
		
		System.out.println(min - 1);
		
		
	}

}