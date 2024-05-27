import java.util.Scanner;

public class Main {
	
	static long N;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		
		/*
		 *  n1 = 1, 1
		 *  n2 = 6, 7
		 *  n3 = 12, 19
		 *  n4 = 18
		 *  n5 = 24
		 */
		
		long sum = 1;
		count = 1;
		boolean flag = true;
		
		while(flag) {
			if(N <= sum) {
				flag = false;
				continue;
			}
			
			if(N > sum) {
				sum += 6 * count;
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
