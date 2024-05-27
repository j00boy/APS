import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] sel;
	static int[] cards;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		max = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		
		cards = new int[N];
		sel = new int[3];
		
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		combination(0, 0);
		
		System.out.println(max);
	}
	
	public static void combination(int idx, int sidx) {
		if(sidx >= 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += sel[i];
			}
			if(sum <= M && sum > max) {
				max = sum;
			}
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		sel[sidx] = cards[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);
	}
}
