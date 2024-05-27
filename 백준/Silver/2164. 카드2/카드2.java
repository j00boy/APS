import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// queue를 사용할 때에는 LinkedList
		Queue<Integer> queue = new LinkedList<>();

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		boolean overOne = true;
		while (overOne) {
			if(queue.size() == 1) {
				overOne = false;
				break;
			}
			queue.poll();
			if (queue.size() <= 1) {
				overOne = false;
				break;
			} else {
				int tmp = queue.poll();
				queue.offer(tmp);
			}
		}

		System.out.println(queue.poll());

	}
}