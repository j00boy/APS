import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int count;
	static List<int[]> flowers;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		flowers = new ArrayList<>();
		N = sc.nextInt();
		count = 0;

		/*
		 * 공주님이 좋아하는날 포함일: 60 <= x <= 334 (3/31 ~ 11/30)
		 */
		
		for (int i = 0; i < N; i++) {
			int startMonth = sc.nextInt();
			int startDay = sc.nextInt();
			int endMonth = sc.nextInt();
			int endDay = sc.nextInt();

			flowers.add(new int[] {getDays(startMonth) + startDay, getDays(endMonth) + endDay});
		}
		
		sortFlower();
		
//		print();
		
		int start = 60;
		int end = 335;
		int idx = 0;
		int max = 0;
		
		while(start < end) {
			
			boolean flag = false;
			
			for(int i = idx; i < N; i++) {
				
				if(flowers.get(i)[0] > start) {
					break;
				}
				
				if(max < flowers.get(i)[1]) {
					flag = true;
					max = flowers.get(i)[1];
					idx = i + 1;
				}
			}
			
			if(flag) {
				start = max;
				count++;
			} else {
				break;
			}
		}
		
		if(max < end) {
			System.out.println(0);
		} else {
			System.out.println(count);
		}
		
		

	}
	
	public static int getDays(int month) {
		int days = 0;
		switch (month) {
		case 1:
			days = 0;
			break;
		case 2:
			days = 31;
			break;
		case 3:
			days = 59;
			break;
		case 4:
			days = 90;
			break;
		case 5:
			days = 120;
			break;
		case 6:
			days = 151;
			break;
		case 7:
			days = 181;
			break;
		case 8:
			days = 212;
			break;
		case 9:
			days = 243;
			break;
		case 10:
			days = 273;
			break;
		case 11:
			days = 304;
			break;
		case 12:
			days = 334;
			break;
		default:
			break;
		}
		
		return days;
	}
	
	public static void print() {
		for(int[] flower : flowers) {
			System.out.print("[" + flower[0] + ", " + flower[1] + "] ");
		}
	}
	
	public static void sortFlower() {
		Collections.sort(flowers, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
			
		});
	}
}
