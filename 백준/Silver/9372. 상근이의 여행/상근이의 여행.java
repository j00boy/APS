import java.util.Scanner;

class Node {
	int data;
	Node link;
	
	Node() {}
	
	Node(int data) {
		this.data = data;
	}
}

public class Main {
	
	static int N;
	static int M;
	static Node[] nations;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// test case
		
		for(int tc = 0; tc < T; tc++) {
			N = sc.nextInt();	// 국가의 수
			M = sc.nextInt();	// 비행기의 종류
			nations = new Node[N+1];
			
			for(int i = 1; i <= M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
			}
			
			System.out.println(N-1);
		}
	}
}