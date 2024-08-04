import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int K;
	static int L;
	static int[][] map;
	static int now;
	static int time;
	static int d;
	static Queue<int[]> snake;
	static List<String[]> info;
	static int sum;
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+1][N+1];
		now = 0;
		d = 0;
		sum = 0;
		snake = new LinkedList<>();
		info = new ArrayList<>();
		map[1][1] = 1;
		snake.add(new int[] {1, 1});

		for(int i = 0; i < K; i++) {
			map[sc.nextInt()][sc.nextInt()] = -1;
		}
		
		L = sc.nextInt();
		
		for(int i = 0; i < L; i++) {
			info.add(new String[] {sc.next(), sc.next()});
		}
		
//		System.out.println("===== 초기세팅 =====");
//		print();
		
		
		int head_r = 1;
		int head_c = 1;
		
		boolean flag = true;
		// 왼쪽이 L, 오른쪽이 D
		for(int i = 0; i < L; i++) {
			
			if(!flag) {
				break;
			}
			
			time = Integer.parseInt(info.get(i)[0]);
			String dir = info.get(i)[1];
			
			for(int j = now; j < time; j++) {
				sum++;	// 시간 증가
				int next_r = head_r + dr[d];
				int next_c = head_c + dc[d];
				
				// 벽이나 몸이랑 부딪히는게 아니라면
				if(check(next_r, next_c)) {
					
					if(map[next_r][next_c] != -1) {	// 사과가 아니라면 꼬리칸 제거
						int[] tail = snake.poll();
						map[tail[0]][tail[1]] = 0;
					}
					
					map[next_r][next_c] = 1;
					snake.add(new int[] {next_r, next_c});
					head_r = next_r;
					head_c = next_c;
					
				} else {
					flag = false;
					break;
				}
//				print();
			}
			
			if(dir.equals("L")) {
				if(d == 0) {
					d = 3;
				} else {
					d = d - 1;
				}
			} else {
				if(d == 3) {
					d = 0;
				} else {
					d = d + 1;
				}
			}
			
			now = time;
		}
		
		if(flag) {
			while(true) {
				sum++;	// 시간 증가
				int next_r = head_r + dr[d];
				int next_c = head_c + dc[d];
				
				// 벽이나 몸이랑 부딪히는게 아니라면
				if(check(next_r, next_c)) {
					
					if(map[next_r][next_c] != -1) {	// 사과가 아니라면 꼬리칸 제거
						int[] tail = snake.poll();
						map[tail[0]][tail[1]] = 0;
					}
					
					map[next_r][next_c] = 1;
					snake.add(new int[] {next_r, next_c});
					head_r = next_r;
					head_c = next_c;
					
				} else {
					flag = false;
					break;
				}
			}
		}
		
		System.out.println(sum);
		
	}
	
	static boolean check(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= N && map[r][c] != 1;
	}
	
	static void print() {
		System.out.println("======================");
		System.out.println("Queue: " + snake);
		System.out.println("======================");
		for(int r = 1; r < N; r++) {
			for(int c = 1; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}
