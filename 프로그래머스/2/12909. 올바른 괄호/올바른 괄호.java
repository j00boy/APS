import java.util.*;

class Solution {
    boolean solution(String s) {

        // 홀수면 올바르지 않음
        if(s.length() % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}