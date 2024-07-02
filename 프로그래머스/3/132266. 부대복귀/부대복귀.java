import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();  // 인접리스트
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        // 인접리스트 크기에 맞게 초기화
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < roads.length; i++) {
            adjList.get(roads[i][0]).add(roads[i][1]);
            adjList.get(roads[i][1]).add(roads[i][0]);
        }
        
        // for(int i = 1; i <= n; i++) {
        //     System.out.println(adjList.get(i));
        // }
        
        for(int i = 0; i < sources.length; i++) {
            answer[i] = BFS(sources[i], destination, n);
        }
        
        return answer;
    }
    
    public int BFS(int num, int destination, int n) {
        
        // 기저조건
        if(num == destination) {
            return 0;
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(num);
        queue.add(0);   // dist
        visited[num] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int dist = queue.poll();
            
            for(int i : adjList.get(now)) {
                if(!visited[i]) {
                    if(i == destination) {
                        return dist + 1;
                    }
                    
                    visited[i] = true;
                    queue.add(i);
                    queue.add(dist + 1);
                    
                    
                }
            }
        }
        
        return -1;
    }
}