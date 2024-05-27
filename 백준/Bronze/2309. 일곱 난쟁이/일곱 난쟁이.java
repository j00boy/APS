import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] 난쟁이 = new int[9];
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			난쟁이[i] = sc.nextInt();
			sum += 난쟁이[i];
		}
		
		Arrays.sort(난쟁이);
		
		int 범인1 = 0;
		int 범인2 = 0;
		
		for(int i = 0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) {
				if(sum - 난쟁이[i] - 난쟁이[j] == 100) {
					범인1 = 난쟁이[i];
					범인2 = 난쟁이[j];
					break;
				}
			}
		}
		
		
		for(int i = 0; i < 9; i++) {
			if(난쟁이[i] != 범인1 && 난쟁이[i] != 범인2) {
				System.out.println(난쟁이[i]);
			}
		}
		
	}
		
}
