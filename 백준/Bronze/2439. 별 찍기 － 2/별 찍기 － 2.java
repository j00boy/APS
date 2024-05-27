import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			String space = "";
			for(int j = N-i; j > 0; j--) {
				space += " ";
			}
			
			for(int j = 1; j <= i; j++) {
				space += "*";
			}
			System.out.print(space);
			System.out.println();
		}
	}
}
