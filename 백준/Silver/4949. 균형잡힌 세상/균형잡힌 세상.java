import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

//		File file = new File("src/BOJ_2164_카드2/input.txt");
//		Scanner sc = new Scanner(file);

		Scanner sc = new Scanner(System.in);

		boolean keepGoing = true;
		while (keepGoing) {
			
			String str = sc.nextLine();
			
			if(str.charAt(0) == '.' && str.length() == 1) {
				keepGoing = false;
				break;
			}

			Stack<Character> stack = new Stack<>();

			boolean isOK = true;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						isOK = false;
						break;
					} else {
						stack.pop();
					}
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						isOK = false;
						break;
					} else {
						stack.pop();
					}
				} else if(c == '.') {
					break;
				}
			}

			if (isOK && stack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			
			
		}

	}
}