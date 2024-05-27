import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		StringBuffer sb = new StringBuffer("a" + str);
		
		String[] suffix = new String[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			sb = sb.deleteCharAt(0);
			suffix[i] = sb.toString();
		}
		
		Arrays.sort(suffix);
		
		for(int i = 0; i < suffix.length; i++) {
			System.out.println(suffix[i]);
		}
		
	}
}