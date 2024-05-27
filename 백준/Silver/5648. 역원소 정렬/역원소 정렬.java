import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] elements = new String[N];
		long[] list = new long[N];
		
		for(int i = 0; i < N; i++) {
			elements[i] = sc.next();
		}
		
		for(int i = 0; i < N; i++) {
			StringBuffer sb = new StringBuffer(elements[i]);
			String reverseStr = sb.reverse().toString();
			list[i] = Long.valueOf(reverseStr);
		}
		
		Arrays.sort(list);
		for(int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}
		
	}
}