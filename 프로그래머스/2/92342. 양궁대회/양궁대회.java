import java.util.*;

class Solution {
    
    static int max;
    static int appeach_score;
    static int ryan_score;
    static int[] ryan;
    static int count;
    static int[] answer;
    
    public int[] solution(int n, int[] info) {
        count = n;
        ryan = new int[11];
        answer = new int[11];
        
        appeach_score = 0;
        ryan_score = 0;
        max = 0;
        
        combination(0, 0, info);
        
        if(max == 0) {
            answer = new int[] {-1};
        }
        
        // System.out.println(max);
        return answer;
    }
    
    public void combination(int used, int idx, int[] info) {
        // 기저조건
        if(used == count) {
            // System.out.println(Arrays.toString(ryan));
            getScore(ryan, info);
            if(ryan_score > appeach_score && ryan_score - appeach_score >= max) {
                if(ryan_score - appeach_score == max) {
                    // 더 낮은 값이 많은 것
                    for(int i = 10; i >= 0; i--) {
                        if(ryan[i] > answer[i]) {
                            break;
                        } else if(ryan[i] < answer[i]) {
                            return;
                        }
                    }
                }
                
                for(int i = 0; i < 11; i++) {
                    answer[i] = ryan[i];
                }
                
                if(max < ryan_score - appeach_score) {
                    max = ryan_score - appeach_score;
                }
                
            }
            return;
        }
        
        if(idx >= info.length) {
            return;
        }
        
        for(int i = count - used; i >= 0; i--) {
            ryan[idx] = i;
            combination(used + i, idx + 1, info);
        }
        
    }
    
    public void getScore(int[] arr, int[] info) {
        appeach_score = 0;
        ryan_score = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > info[i]) {
                ryan_score += (10 - i);
            } else if(arr[i] <= info[i] && info[i] != 0) {
                appeach_score += (10 - i);
            }
            
        }
        
    }
}