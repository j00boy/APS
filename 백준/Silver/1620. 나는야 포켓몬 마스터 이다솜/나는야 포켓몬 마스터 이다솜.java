import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static int N;	// 도감에 수록되어 있는 포켓몬의 개수
	static int M;	// 내가 맞춰야 하는 문제의 개수
	static Map<String, String> dictionary1;
	static Map<String, String> dictionary2;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		dictionary1 = new HashMap<>();
		dictionary2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String pokemon = sc.next();
			dictionary1.put(String.valueOf(i), pokemon);
			dictionary2.put(pokemon, String.valueOf(i));
		}
		
		for(int i = 0; i < M; i++) {
			String input = sc.next();
			
			if(dictionary1.containsKey(input)) {	// 숫자라는 뜻
				System.out.println(dictionary1.get(input));
			} else {
				System.out.println(dictionary2.get(input));
			}
		}
	}
}
