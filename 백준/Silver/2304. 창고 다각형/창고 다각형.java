import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] roof = new int[1001];
		
		int start = 1000;
		int end = 0;
		int highest = 0;
		int highestIdx = 0;
		
		for(int i = 0; i < N; i++) {
			int idx = sc.nextInt();
			int hgt = sc.nextInt();
			
			roof[idx] = hgt;
			
			if(idx < start) {
				start = idx;
			}
			
			if(hgt >= highest) {
				highest = hgt;
				highestIdx = idx;
			}
			
			if(idx > end) {
				end = idx;
			}
		}
		
		
		int now1 = roof[start];
		int area1 = 0;
		
		for(int i = start; i <= highestIdx; i++) {
			// 현재 높이보다 크다면 갱신
			if(roof[i] > now1) {
				now1 = roof[i];
				area1 += now1;
			} else if(roof[i] == 0) {
				area1 += now1;
			} else {
				area1 += now1;
			}
		}
		
		int now2 = roof[end];
		int area2 = 0;
		
		for(int i = end; i >= highestIdx; i--) {
			if(roof[i] > now2) {
				now2 = roof[i];
				area2 += now2;
			} else if(roof[i] == 0) {
				area2 += now2;
			} else {
				area2 += now2;
			}
		}
		
		int total = area1 + area2 - highest;
		
		System.out.println(total);
		
	}
}