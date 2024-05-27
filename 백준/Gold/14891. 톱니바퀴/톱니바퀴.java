import java.util.Scanner;

public class Main {
	
	static int[] checked;
	static String[] tob = new String[5];
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		tob[1] = "T" + sc.next();
		tob[2] = "T" + sc.next();
		tob[3] = "T" + sc.next();
		tob[4] = "T" + sc.next();
		
		K = sc.nextInt();
		int sum = 0;
		
		// 회전 K번만큼 시작
		for(int t = 0; t < K; t++) {
			int idx = sc.nextInt();
			int dir = sc.nextInt();
			checked = new int[5];
			checked[idx] = dir;			
			right(idx);
			left(idx);
			
//			System.out.println(Arrays.toString(checked));
			
			for(int i = 1; i <= 4; i++) {
				if(checked[i] == 1) {
					tob[i] = rotate(tob[i]);
				} else if(checked[i] == -1) {
					tob[i] = rotate_reverse(tob[i]);
				}
//				System.out.println(tob[i]);
			}
		}
		
		for(int i = 1; i <= 4; i++) {
			if(tob[i].charAt(1) == '1') {
				sum += Math.pow(2, i-1);
			}
		}
		
		System.out.println(sum);
	}
	
	public static String rotate(String str) {
		char ch = str.charAt(8);
		str = "T" + ch + str.substring(1, 8);
		
		return str;
	}
	
	public static String rotate_reverse(String str) {
		char ch = str.charAt(1);
		str = "T" + str.substring(2, 9) + ch;
		
		return str;
	}
	
	// 경계 확인
	public static boolean check(int idx) {
		return idx >= 1 && idx <= 4;
	}
	
	public static void right(int idx) {
		if(check(idx + 1)) {
			if(tob[idx].charAt(3) != tob[idx+1].charAt(7)) {
				if(checked[idx] == 1) {
					checked[idx+1] = -1;
				} else if(checked[idx] == -1) {
					checked[idx+1] = 1;
				}
				right(idx + 1);
			}
		}
	}
	
	public static void left(int idx) {
		if(check(idx - 1)) {
			if(tob[idx].charAt(7) != tob[idx-1].charAt(3)) {
				if(checked[idx] == 1) {
					checked[idx - 1] = -1;
				} else if(checked[idx] == -1) {
					checked[idx - 1] = 1;
				}
				left(idx-1);
			}
		}
	}
	
	
}