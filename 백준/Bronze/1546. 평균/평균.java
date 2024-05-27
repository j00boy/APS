import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		double[] arr = new double[N];
		
		double max = 0;
		double sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		double avg = (double) (sum / N) / max * 100;
		
		System.out.println(avg);
				
	}
}
