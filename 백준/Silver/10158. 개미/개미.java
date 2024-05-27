import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st1.nextToken());
		int q = Integer.parseInt(st1.nextToken());
		
		int time = Integer.parseInt(br.readLine());
		
		p = ((p + time) % (2 * W)) <= W ? (p + time) % (2 * W) : 2*W - ((p + time) % (2 * W));
		q = ((q + time) % (2 * H)) <= H ? ((q + time) % (2 * H)) : 2*H - ((q + time) % (2 * H));

		System.out.println(p + " " + q);
		
	}

}
