import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 타로가 낼 돈
		int change = 1000 - sc.nextInt();
		
		// 이거는 Arrays.sort(arr, Collections.reverseOrder()) 연습
		// 내림차순 시에는, 기본 자료형 배열은 안 되고 Wrapper 클래스만 가능
		Integer[] money = {100, 500, 5, 1, 50, 10};
		
		Arrays.sort(money, Collections.reverseOrder());
		
		int count = 0;			// 각 잔돈 단위에서 체크할 카운트 
		int totalCount = 0;		// 총 잔돈 개수의 합
		
		for(int i = 0; i < 6; i++) {
			int tmp = change;
			count = tmp / money[i];	// 최대로 나눌 수 있는 잔돈까지 합을 구하고 
			totalCount += count;	// total에 값을 합치고 
			change %= money[i];		// 잔돈을 나눈 나머지를 남은 잔돈으로 갱신한다.
		}
		
		System.out.println(totalCount);
	}
}
