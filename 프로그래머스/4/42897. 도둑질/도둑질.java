import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] money) {
        int max = 0;
        
        int[] D = new int[money.length];
        
        // 첫집을 텀
        D[0] = money[0];
        D[1] = D[0];
        for(int i = 2; i < money.length - 1; i++) {
            D[i] = Math.max(D[i - 2] + money[i], D[i-1]);
        }
        
        max = Math.max(max, D[money.length - 2]);
        
        Arrays.fill(D, 0);
        // System.out.println(Arrays.toString(D));
        
        // 첫집을 안텀
        D[0] = 0;
        D[1] = money[1];
        for(int i = 2; i < money.length; i++) {
            D[i] = Math.max(D[i-2] + money[i], D[i-1]);
        }
        
        max = Math.max(max, D[money.length - 1]);
        
        return max;
    }
}