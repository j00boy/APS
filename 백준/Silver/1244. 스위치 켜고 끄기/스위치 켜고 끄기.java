import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] buttons = new int[N + 1];
		buttons[0] = 3;

		for (int i = 1; i <= N; i++) {
			buttons[i] = sc.nextInt();
		}

		int stu = sc.nextInt();

		for (int i = 0; i < stu; i++) {
			int gender = sc.nextInt();
			int number = sc.nextInt();

			if (gender == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % number == 0) {
						if (buttons[j] == 1)
							buttons[j] = 0;
						else
							buttons[j] = 1;
					}
				}
			}
			
			else {
				int start = number;
				int end = number;
				
				while (start >= 1 && end <= N) {
					if (buttons[start] == buttons[end]) {
						start--;
						end++;
					} else {
						break;
					}
				}
				start++;
				end--;

				for (int j = start; j <= end; j++) {
					if (buttons[j] == 1)
						buttons[j] = 0;
					else if (buttons[j] == 0)
						buttons[j] = 1;
				}
			}
		}

		String ans = "";
		for (int i = 1; i <= N; i++) {
			if (i % 20 == 0) {
				ans += buttons[i] + " ";
				ans += "\n";
			} else {
				ans += buttons[i] + " ";
			}
		}

		System.out.println(ans);

	}

}
