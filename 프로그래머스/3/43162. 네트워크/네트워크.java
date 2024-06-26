import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        // 초기화
        int answer = 0;
        visited = new boolean[n];
        
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                BFS(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void BFS(int com, int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();
        visited[com] = true;
        
        queue.add(com);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}