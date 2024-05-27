import java.util.Scanner;

public class Main {

	public static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			String str = sc.next();
			count = 0;
			System.out.println(isPalindrome(str) + " " + count);
			
		}
	}

	public static int recursion(String s, int start, int end) {
		count++;
		if(start >= end) {
			return 1;
		} else if(s.charAt(start) != s.charAt(end)) {
			return 0;
		} else {
			return recursion(s, start+1, end-1);
		}
	}
	
	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length()-1);
	}
	
}
