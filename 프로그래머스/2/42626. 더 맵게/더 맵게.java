import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 초기화
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(true) {
            int small = 0;
            int smaller = 0;
            
            if(queue.size() == 1) {
                if(queue.peek() < K) {
                    answer = -1;
                    break;
                } else {
                    break;
                }
            }
            
            smaller = queue.poll();
            small = queue.poll();
            // System.out.println("smaller: " + smaller);
            // System.out.println("small: " + small);
            
            if(smaller >= K) {
                break;
            }
            
            queue.add(smaller + (small * 2));
            
            answer++;
        }
        
        
        
        
        return answer;
    }
}