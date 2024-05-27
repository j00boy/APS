import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		out: for(int i = 0; i < T; i++) {
			String str = sc.next();
			char[] arr = str.toCharArray();
			
			Stack<Character> stack = new Stack<>();
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == '(') {
					stack.add('(');
				} else {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else if(stack.isEmpty() || stack.peek() == ')') {
						System.out.println("NO");
						continue out;
					}
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
