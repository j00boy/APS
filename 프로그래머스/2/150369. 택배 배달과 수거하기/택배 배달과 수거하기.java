import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        
        long total = 0;
        
        int d_idx = n - 1;
        int p_idx = n - 1;
        
        while(d_idx >= 0 || p_idx >= 0) {
            int start = cap;
            int pick = 0;
            
            int d_max = 0;
            int p_max = 0;
            
            while(start > 0 && d_idx >= 0) {
                if(deliveries[d_idx] != 0) {
                    if(d_max == 0) {
                        d_max = d_idx + 1;
                    }
                    if(deliveries[d_idx] <= start) {
                        start -= deliveries[d_idx];
                        deliveries[d_idx] = 0;
                        d_idx--;
                    } else {
                        deliveries[d_idx] -= start;
                        start = 0;
                    }
                } else {
                    d_idx--;
                }
            }
            
            while(pick < cap && p_idx >= 0) {
                if(pickups[p_idx] != 0) {
                    if(p_max == 0) {
                        p_max = p_idx + 1;
                    }
                    if(pickups[p_idx] <= cap - pick) {
                        pick += pickups[p_idx];
                        pickups[p_idx] = 0;
                        p_idx--;
                    } else {
                        pickups[p_idx] -= (cap - pick);
                        pick = cap;
                    }
                } else {
                    p_idx--;
                }
            }
            
            // System.out.println("d_max: " + d_max + ", p_max: " + p_max);
            if(d_max >= p_max) {
                total += d_max * 2;
            } else {
                total += p_max * 2;
            }
        }
        
        return total;
    }
}