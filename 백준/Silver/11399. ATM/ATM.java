import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		// counting 배열로 전환
		for(int i = 1; i < N; i++) {
			list[i] += list[i-1];
		}
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += list[i];
		}
		
		System.out.println(sum);
		
	}
}