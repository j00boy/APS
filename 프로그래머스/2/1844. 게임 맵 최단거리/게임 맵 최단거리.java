import java.util.*;

class Solution {
    
    static int n;
    static int m;
    static int answer;
    
    public int solution(int[][] maps) {
        
        BFS(maps);
        
        return answer;
    }
    
    static void BFS(int[][] maps) {
        
        answer = -1;
        n = maps.length;
        m = maps[0].length;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        queue.add(0);
        queue.add(1);
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int now_r = queue.poll();
            int now_c = queue.poll();
            int now_dist = queue.poll();
            
            for(int d = 0; d < 4; d++) {
                int nr = now_r + dr[d];
                int nc = now_c + dc[d];
                int n_dist = now_dist + 1;
                
                if(check(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(nr);
                    queue.add(nc);
                    queue.add(n_dist);
                }
            }
            
            if(visited[n-1][m-1]) {
                answer = now_dist + 1;
                break;
            }
        }
        
    }
    
    static boolean check(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

}