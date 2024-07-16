import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int K;

	static boolean[] selected;
	static int[][] jewelry;
	static int[] bag;
	
	
	static int[][] D;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		selected = new boolean[N];
		jewelry = new int[N][2];
		bag = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewelry[i][0] = Integer.parseInt(st.nextToken());
			jewelry[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(jewelry, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		Arrays.sort(bag);
//		System.out.println(Arrays.toString(bag));
		
		// PriorityQueue 말고 LinkedList같은 애들도 가능은 할거같음
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		
		int idx = 0;
		for(int i = 0; i < K; i++) {
			while(idx < N) {
				if(bag[i] >= jewelry[idx][0]) {
					pq.add(jewelry[idx][1]);
					idx++;
				} else {
					break;
				}
			}
//			System.out.println(pq);
			
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		
		
//		for(int w : bag) {
//			for(int i = 0; i < jewelry.length; i++) {
//				if(!selected[i] && jewelry[i][0] < w) {
//					selected[i] = true;
//					answer += jewelry[i][1];
//					break;
//				}
//			}
//		}
		
		System.out.println(answer);
	}
}
