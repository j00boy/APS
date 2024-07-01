import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        // n: 가로, m: 세로 (시작점이 [1,1] 이니까)
        int[][] D = new int[n + 1][m + 1];
        
        // 집 표시해주기, 학교는 어차피 (n,m)
        D[1][1] = 1;
        
        // 물웅덩이 표시해주기
        for(int[] arr : puddles) {
            int puddle_r = arr[1];
            int puddle_c = arr[0];
            
            D[puddle_r][puddle_c] = 987654321;
        }
        
        // 방향은 오른쪽, 아랫쪽만 진행하는 것이 최단거리
        for(int r = 1; r <= n; r++) {
            for(int c = 1; c <= m; c++) {
                if(D[r][c] != 987654321) {          // 도착지가 웅덩이가 아닐 때만
                    if(D[r-1][c] != 987654321) {    // 위에서 아래로 내려올 수 있으면, D[r-1][c]에 갈 수 있는 경우의 수를 더함
                        D[r][c] += D[r-1][c];
                        D[r][c] %= 1000000007;
                    }
                    if(D[r][c-1] != 987654321) {    // 왼쪽에서 오른쪽으로 갈 수 있으면, D[r][c-1]에 갈 수 있는 경우의 수를 더함
                        D[r][c] += D[r][c-1];
                        D[r][c] %= 1000000007;
                    }
                }
            }
        }
        
        // for(int r = 1; r <= n; r++) {
        //     for(int c = 1; c <= m; c++) {
        //         System.out.print(D[r][c] + " ");
        //     }
        //     System.out.println();
        // }
        
        return D[n][m];
    }
}