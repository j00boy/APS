import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 0;

		for (int i = 0; i < N; i++) {
			if(isPrime(sc.nextInt())) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n % j == 0) {
				return false;
			}
		}
		return true;
	}
}
