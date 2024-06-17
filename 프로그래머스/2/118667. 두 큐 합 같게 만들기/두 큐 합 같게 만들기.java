import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long count = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for(long i : queue1) {
            q1.add(i);
        }
        
        for(long i : queue2) {
            q2.add(i);
        }
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        while(sum1 != sum2) {
            if(count > (q1.size() + q2.size()) * 2) {
                return -1;
            }
            
            if(sum1 > sum2) {
                long out = q1.poll();
                q2.add(out);
                sum1 -= out;
                sum2 += out;
            } else {
                long out = q2.poll();
                q1.add(out);
                sum1 += out;
                sum2 -= out;
            }
            count++;
            
            if(q1.isEmpty() || q2.isEmpty()) {
                return -1;
            }
        }
        
        return (int) count;
    }
}