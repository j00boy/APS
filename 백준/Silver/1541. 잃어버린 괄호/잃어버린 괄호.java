import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String exp = sc.next();
		
		/*
		 * 50-40+30-20
		 * [50, 40+30, 20]
		 */
		
		int result = 0;
		
		String[] arr = exp.split("\\-");
		int[] nums = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i].contains("+")) {
				nums[i] = Integer.parseInt(arr[i]);
			} else {
				String[] tmp = arr[i].split("\\+");
				int sum = 0;
				for(String s : tmp) {
					sum += Integer.parseInt(s);
				}
				nums[i] = sum;
			}
		}
		
		result = nums[0];

		for(int i = 1; i < nums.length; i++) {
			result -= nums[i];
		}
		
		System.out.println(result);
		
	}
}