import java.util.Scanner;

public class Main {
	
	static StringBuilder sb;
	static String S;
	static String T;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		answer = 0;
		S = sc.next();
		T = sc.next();
		
		/*
		 * 1. 문자열 뒤에 A를 추가한다.
		 * 2. 문자열 뒤에 B를 추가하고 문자열을 뒤집는다.
		 */
		
		calculate(T);
		
		System.out.println(answer);
	}
	
	public static void calculate(String str) {
		
		if(answer == 1) {
			return;
		}
		
//		System.out.println(str);
		
		
		// 기저 조건
		if(str.equals(S)) {
			answer = 1;
			return;
		}
		
		if(str.length() <= S.length()) {
			return;
		}
		
		if(str.charAt(str.length() - 1) == 'A') {
			sb = new StringBuilder(str);
			sb.deleteCharAt(sb.length()-1);
			calculate(sb.toString());
		}
		
		if(str.charAt(0) == 'B') {
			sb = new StringBuilder(str);
			sb.reverse();
			sb.deleteCharAt(sb.length()-1);
			calculate(sb.toString());
		}
	}
}
