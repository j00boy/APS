import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] schedule = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			schedule[i][0] = sc.nextInt();
			schedule[i][1] = sc.nextInt();
		}
		
		// 끝나는 시간 기반으로 오름차순 정렬, 만약 같다면 시작 시간 기준으로 오름차순 정렬
		Arrays.sort(schedule, new Comparator<int[]>() {

			@Override
			public int compare(int[] sch1, int[] sch2) {
				if(sch1[1] == sch2[1]) {
					return sch1[0] - sch2[0];
				}
				return sch1[1] - sch2[1];
			}
		});
		
		// 시작은 첫 원소 
		int count = 0;
		int endTime = 0;
		
		// 이미 정렬을 완료했기 때문에, 그대로 for문만 돌면 됨
		for(int i = 0; i < N; i++) {
			if(schedule[i][0] >= endTime) {	// 시작시간이 가능한 시간이라면 
				endTime = schedule[i][1];	// 해당 스케줄 채택 
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}
}