import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String sentence = sc.next().toUpperCase();
		
		int[] counts = new int[27];
		
		for(int i = 0; i < sentence.length(); i++) {
			counts[sentence.charAt(i) - '@']++;
		}
		
		
		int maxCnt = 0;
		int maxIdx = 0;
		for(int i = 1; i < 27; i++) {
			if(counts[i] > maxCnt) {
				maxCnt = counts[i];
				maxIdx = i;
			}
		}
		
//		System.out.println(maxCnt);
//		System.out.println(maxIdx);
		
		char result = 0;

		int freq = 0;
		for(int i = 1; i < 27; i++) {
			if(counts[i] == maxCnt) freq++;
		}
		
		if(freq > 1) result = '?';
		else result = (char) (maxIdx + '@');
		
		System.out.println(result);
	}
}
