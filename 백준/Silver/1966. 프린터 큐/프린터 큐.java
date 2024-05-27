import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> idx = new LinkedList<>();

		int T = sc.nextInt();

		/*
		 * N: 문서의 개수 M: 몇 번째로 인쇄되었는지 궁금한 문서가 현재 queue에서의 index
		 */

		// test case 시작
		for (int tc = 1; tc <= T; tc++) {
			queue.clear();
			idx.clear();
			int N = sc.nextInt();
			int M = sc.nextInt();

			for (int i = 0; i < N; i++) {
				queue.offer(sc.nextInt());
				idx.offer(i);
			}

			int printCount = 0;
			boolean flag = true;

			while (flag) {
				// max 구하기
				int max = 0;
				int maxIdx = 0;
				for (int i = 0; i < N; i++) {
					if (queue.peek() > max) {
						max = queue.peek();
						maxIdx = idx.peek();
					}
					int tmp = queue.poll();
					queue.offer(tmp);
					int tmpIdx = idx.poll();
					idx.offer(tmpIdx);
				}

				// max값에 갈 때 까지 빼고 넣기
				while (idx.peek() != maxIdx) {
					int tmp = queue.poll();
					queue.offer(tmp);
					int tmpIdx = idx.poll();
					idx.offer(tmpIdx);
				}

				// 값이 max일 때, index 비교
				if (idx.peek() != M) {
					queue.poll();
					idx.poll();
					printCount++;
				} else {
					printCount++;
					flag = false;
					break;
				}

			}
			// while문 끝
//			System.out.println(targetIdx);
			System.out.println(printCount);
//			System.out.println(queue);
//			System.out.println(idx);
		}
		// test case 끝
	}

}