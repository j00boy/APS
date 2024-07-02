import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int n;
	static int[][] dots;
	static Stack<Integer> stack;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dots = new int[n][2];	// x, y
		stack = new Stack<>();
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			dots[i][0] = sc.nextInt();
			dots[i][1] = sc.nextInt();
		}
		
		// x축은 안중요하고 y축이 높이니까 중요
		for(int i = 0; i < n; i++) {
			if(stack.isEmpty()) {	// 비어 있다면 무조건 넣기
				stack.add(dots[i][1]);
			} else {	// 안 비어 있다면
				// 1. 그냥 더 높은 애가 나오면 stack에 축자
				
				// 2. 아니라면
				// 새로운 스카이라인고도가 더 높아질때까지 count++
				while(!stack.isEmpty() && stack.peek() > dots[i][1]) {
//					System.out.println(stack);
					count++;
					stack.pop();
				}
				
				// 같은 높이는 이미 stack에 있으니까 추가 안됨
				
				// stack이 비어있거나, 높이가 다르다 == 새로운 스카이라인 고도가 더 높다
//				if(!stack.isEmpty()) {
//					System.out.println("스택: " + stack.peek() + ", 고도: " + dots[i][1]);					
//				}
				
				if(stack.isEmpty() || (stack.peek() != dots[i][1] && stack.peek() < dots[i][1])) {
					stack.add(dots[i][1]);
				}
			}
		}
		
//		System.out.println(count + ", " + stack);
		
		while(!stack.isEmpty()) {
			int num = stack.pop();
			if(num != 0) {	// 높이가 0인 빌딩은 있을 수가 없음
				count++;
			}
		}
		
		System.out.println(count);
	}
}
