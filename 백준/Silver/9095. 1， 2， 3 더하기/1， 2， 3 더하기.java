import java.util.Scanner;

public class Main {
	
	static int count;
	static int[] D = new int[11];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		// test case
		for(int tc = 1; tc <= T; tc++) {
			count = 0;
			int num = sc.nextInt();
			D[0] = 1;
			D[1] = 1;
			D[2] = 2;
			if(num >= 3) {
				System.out.println(topDown(num));
			} else {
				System.out.println(D[num]);
			}
			
			
		}
		// test case
	}
	
	static int topDown(int n) {
		if(D[n] == 0) {
			return topDown(n-1) + topDown(n-2) + topDown(n-3);
		}
		return D[n];
	}
}

/*
 * 1: 1
 * 2: 2
 * 3: 4
 * 4: 7
 * 5: 13
 * 6: 24
 * 7: 44
 * D[i] = D[i-1] + D[i-2] + D[i-3]
*/ 