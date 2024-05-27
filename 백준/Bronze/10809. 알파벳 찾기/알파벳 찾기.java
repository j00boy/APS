import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		char[] alphabets = new char[27];
		alphabets[0] = '`';
		for(int i = 1; i < 27; i++) {
			alphabets[i] = (char) (alphabets[i-1]+1);
		}
		String answer = "";
		for(int i = 1; i < 27; i++) {
			if(word.contains(String.valueOf(alphabets[i]))) {
				answer += word.indexOf(alphabets[i])+ " ";
			} else {
				answer += "-1" + " ";
			}
		}
		
		System.out.println(answer);
		
	}
}