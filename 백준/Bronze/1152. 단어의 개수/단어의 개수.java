import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		if(str.equals(" ")) {
			System.out.println(0);
		} else if(str.charAt(0) == ' ') {
			System.out.println(str.split(" ").length-1);
		} else {
			System.out.println(str.split(" ").length);
		}
	}
}
