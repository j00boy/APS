import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int[] sel;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        sel = new int[M];
        visited = new boolean[N];
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums); // 정렬하여 순열 구성에서 중복을 방지하기 위함
        permutation(0);

        System.out.println(sb);
    }

    public static void permutation(int idx) {
        if (idx >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prevNum = -1; // 이전에 선택한 숫자를 기억하기 위한 변수
        for (int i = 0; i < N; i++) {
            if (!visited[i] && prevNum != nums[i]) { // 이미 선택되지 않았고, 이전에 선택한 숫자가 아닌 경우에만 선택
                sel[idx] = nums[i];
                visited[i] = true;
                prevNum = nums[i]; // 현재 선택한 숫자를 이전에 선택한 숫자로 설정
                permutation(idx + 1);
                visited[i] = false;
            }
        }
    }
}
