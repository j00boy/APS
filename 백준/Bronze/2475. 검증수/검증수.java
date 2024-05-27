import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int[] nums = new int[5];
		
		for(int i = 0; i < 5; i++) {
			nums[i] = sc.nextInt();
		}
		
		int checkNum = 0;
		for(int i = 0; i < 5; i++) {
			checkNum += Math.pow(nums[i], 2);
		}
		
		checkNum %= 10;
		
		System.out.println(checkNum);
	}
}
