import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];  // 정점, 도넛, 막대, 8자
        // 정점: 나가는 애만 있음
        // 도넛: 자기 자신을 가리킴
        // 막대: 그래프의 맨 끝 노드는 from이 없음
        // 8자: to는 2개 이상, from은 1개
        int max = 0;
        for(int r = 0; r < edges.length; r++) {
            for(int c = 0; c < 2; c++) {
                max = Math.max(max, edges[r][c]);
            }
        }
        
        // 여기는 카운트 배열을 채워 넣음
        int[] from = new int[max + 1];
        int[] to = new int[max + 1];
        
        for(int r = 0; r < edges.length; r++) {
            for(int c = 0; c < 2; c++) {
                if(c == 0) from[edges[r][c]]++;
                else to[edges[r][c]]++;
            }
        }
        
        for(int i = 1; i < max + 1; i++) {
            if(from[i] >= 2 && to[i] == 0) {
                answer[0] = i;
            } else if(from[i] == 0 && to[i] >= 1) {
                answer[2]++;
            } else if(from[i] == 2 && to[i] >= 2) {
                answer[3]++;
            }
        }
        
        answer[1] = from[answer[0]] - (answer[2] + answer[3]);
        
        return answer;
    }
}