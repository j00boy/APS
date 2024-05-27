import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String result = sc.next();
			int totalScore = 0;
			int score = 1;

			if(result.charAt(0) == 'O') {
				totalScore += score;
			}
			
			for(int i = 1; i < result.length(); i++) {
				if(result.charAt(i) == 'O') {
					if(result.charAt(i-1) == 'O') {
						score += 1;
						totalScore += score;
					} else {
						score = 1;
						totalScore += score;
					}
				}
			}
			
			System.out.println(totalScore);
		}
	}
}
