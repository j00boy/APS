import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] adj = new char[26][3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for(int i = 0; i < 26; i++) {
			adj[i][0] = (char) (i + 'A');
		}

		for (int i = 0; i < N; i++) {
			char parent = sc.next().charAt(0);
			char L = sc.next().charAt(0);
			char R = sc.next().charAt(0);
			
			if (L != '.') {
				adj[parent - 'A'][1] = L;
			}
			if (R != '.') {
				adj[parent - 'A'][2] = R;
			}
		}

		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);

		System.out.println(sb);
	}

	// VLR
	public static void preorder(int idx) {
		
		if(idx >= 26) {
			return;
		}
		
		sb.append(adj[idx][0]);
		
		if(adj[idx][1] != '\u0000') {
			preorder(adj[adj[idx][1]-'A'][0]-'A');
		}
		
		if(adj[idx][2] != '\u0000') {
			preorder(adj[adj[idx][2]-'A'][0]-'A');
		}
	
	}

	// LVR
	public static void inorder(int idx) {
		
		if(idx >= 26) {
			return;
		}
		
		if(adj[idx][1] != '\u0000') {
			inorder(adj[adj[idx][1]-'A'][0]-'A');
		}

		sb.append(adj[idx][0]);
		
		if(adj[idx][2] != '\u0000') {
			inorder(adj[adj[idx][2]-'A'][0]-'A');
		}
	}

	// LRV
	public static void postorder(int idx) {
		if(idx >= 26) {
			return;
		}
		
		if(adj[idx][1] != '\u0000') {
			postorder(adj[adj[idx][1]-'A'][0]-'A');
		}

		if(adj[idx][2] != '\u0000') {
			postorder(adj[adj[idx][2]-'A'][0]-'A');
		}
		
		sb.append(adj[idx][0]);
	}
}
