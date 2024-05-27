import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<>();

		int N = sc.nextInt();

		StringBuilder ans = new StringBuilder("");
		int start = 1;
		boolean can = true;

		for (int i = 0; i < N; i++) {
			
			int num = sc.nextInt();

			if (start <= num) {
				for (int j = start; j <= num; j++) {
					stack.push(j);
					ans.append("+\n");
				}
				start = num + 1;
				stack.pop();
				ans.append("-\n");
			} else { // start > num
				if (stack.peek() != num) {
					can = false;
					break;
				} else {
					stack.pop();
					ans.append("-\n");
				}
			}

		}

		if(can && stack.isEmpty()) {
			System.out.println(ans);
		} else {
			System.out.println("NO");
		}

	}
}