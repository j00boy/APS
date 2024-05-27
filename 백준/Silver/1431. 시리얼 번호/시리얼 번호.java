import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] guitars = new String[N];
		
		for(int i = 0; i < N; i++) {
			guitars[i] = sc.next();
		}
		
		Arrays.sort(guitars, new Comparator<String>() {

			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					if(getSum(o1) == getSum(o2)) {
						return o1.compareTo(o2);
					}
					return getSum(o1) - getSum(o2);
				}
				return o1.length() - o2.length();
			}
			
		});
		
		for(String s : guitars) {
			System.out.println(s);
		}
	}
	
	public static int getSum(String str) {
		char[] arr = str.toCharArray();
		int sum = 0;
		for(char ch : arr) {
			if(ch >= '0' && ch <= '9') {
				sum += ch - '0';
			}
		}
		
		return sum;
	}
}