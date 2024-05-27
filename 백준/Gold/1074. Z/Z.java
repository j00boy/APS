import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int number;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int targetR = Integer.parseInt(st.nextToken());
		int targetC = Integer.parseInt(st.nextToken());

		int map_N = (int) Math.pow(2, N);

		recur(targetR, targetC, map_N);
		
		System.out.println(number);


	}

	// r: 시작점
	// c: 시작점
	// targetR
	// targetC

	static void recur(int R, int C, int side) {

		// 기저 조건
		if (side == 1) {
			return;

		} else {

			int div_side = side / 2;
			
			// Z 모양으로 1-2-3-4번 순
			
			// 1. 목표가 4등분을 한 범위 안에 있을 때 재귀
			if(R < div_side && C < div_side) {					// 2사분면
				recur(R, C, div_side);		// count 없음
			}
			// 2. targetR은 안에 있는데, targetC가 밖에 있을 때
			else if(R < div_side && C >= div_side) {			// 1사분면
				recur(R, C-div_side, div_side);
				number += div_side*div_side;					// 2사분면에 대한 count++
			}
			// 3. targetR 밖에 있는데, targetC가 안에 있을 때
			else if(R >= div_side && C < div_side) {			// 3사분면
				recur(R-div_side, C, div_side);
				number += 2 * (div_side * div_side);			// 1, 2사분면에 대한 count++;
			// 4. 둘 다 밖에 있을 때	
			} else {											// 4사분면
				recur(R-div_side, C-div_side, div_side);
				number += 3 * (div_side * div_side);			// 굳이 연산 안하고 number값만 1,2,3 사분면만큼 올림
			}
		}
	}

}