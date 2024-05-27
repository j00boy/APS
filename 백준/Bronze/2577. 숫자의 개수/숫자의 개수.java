import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		String s = String.valueOf(A*B*C);
		
		for(int i = 0; i <= 9; i++) {
			int count = 0;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == i + '0') {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
