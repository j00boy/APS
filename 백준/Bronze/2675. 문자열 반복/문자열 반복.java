import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			String S = sc.next();
			
			String output = "";
			
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < R; j++) {
					output += S.charAt(i)+"";
				}
			}
			
			System.out.println(output);
		}
	}

}
