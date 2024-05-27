import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int L;
	static int C;
	static char[] alphabets;
	static char[] sel;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		alphabets = new char[C];
		sel = new char[L];
		
		for(int i = 0; i < C; i++) {
			alphabets[i] = sc.next().charAt(0);
		}
		
		// 'a'가 1이려면 'a' - 96
		Arrays.sort(alphabets);

		comb(0, 0);
		
		System.out.println(sb);
		
		
	}
	
	public static void comb(int idx, int sidx) {
		if(sidx >= L) {
			int count = 0;
			String s = "";
			for(int i = 0; i < L; i++) {
				if(sel[i] != 'a' &&  sel[i] != 'e' && sel[i] != 'i' && sel[i] != 'o' && sel[i] != 'u') {
					count++;
				}
				s += sel[i];
			}
			s += "\n";
			if(s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
				if(count >= 2) {
					sb.append(s);
					return;
				} else {
					return;
				}
			} else {
				return;
			}
		}
		
		if(idx >= C) {
			return;
		}
		
		sel[sidx] = alphabets[idx];
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}