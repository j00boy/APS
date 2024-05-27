import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[] arr1 = sc.next().toCharArray();
		char[] arr2 = sc.next().toCharArray();
		
		int[][] D = new int[arr1.length][arr2.length];
		
		if(arr1[0] != arr2[0]) {
			D[0][0] = 0;
		} else {
			D[0][0] = 1;
		}
		
		// c-1을 위한 하나짜리 입력
		for(int c = 1; c < arr2.length; c++) {
			if(arr1[0] == arr2[c]) {
				D[0][c] = 1;
			} else {
				if(D[0][c-1] == 1) {
					D[0][c] = 1;
				} else {
					D[0][c] = D[0][c-1];
				}
			}
		}
		
		// r-1을 위한 하나짜리 입력		
		for(int r = 1; r < arr1.length; r++) {
			if(arr1[r] == arr2[0]) {
				D[r][0] = 1;
			} else {
				if(D[r-1][0] == 1) {
					D[r][0] = 1;
				}
				else {
					D[r][0] = D[r-1][0];
				}
			}
		}

		for(int r = 1; r < arr1.length; r++) {
			for(int c = 1; c < arr2.length; c++) {
				if(arr1[r] != arr2[c]) {
					D[r][c] = Math.max(D[r-1][c], D[r][c-1]);	// 같은 행에서 이미 가장 긴 부분수열 vs 전 행에서 나를 고려하지 않았을 때 가장 큰 부분수열
				} else {
					D[r][c] = D[r-1][c-1]+ 1;	// 같은 문자끼리 만난 시점에서, 그 전 버전 + 1 
				}
			}
		}
		
//		for(int r = 0; r < arr1.length; r++) {
//			System.out.println(Arrays.toString(D[r]));
//		}
		
		System.out.println(D[arr1.length-1][arr2.length-1]);
	}
}
