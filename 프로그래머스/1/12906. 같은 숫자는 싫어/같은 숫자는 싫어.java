import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int[] answer;
        
        // 스택으로 쌓으면서 비교
        Stack<Integer> stack = new Stack<>();
        
        // 비었거나 가장 최근꺼랑 같지 않으면 넣음
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty() || !stack.peek().equals(arr[i])) {
                stack.push(arr[i]);
            }
        }
        
        // 스택 크기만큼만 배열 크기 지정
        answer = new int[stack.size()];
        
        // 넣기
        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}