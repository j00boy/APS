import java.util.*;

class Solution {
    
    public int solution(String name) {
        
        int answer = 0;
        
        int leng = name.length();
        
        if(leng == 1) {
            if(name.charAt(0) - 'A' <= 'Z' - name.charAt(0) + 1) {
                answer += name.charAt(0) - 'A';
            } else {
                answer += 'Z' - name.charAt(0) + 1;
            }
            
            return answer;
        } else {
            // 먼저 문자바꾸기부터
            int start = 0;
            int end = 0;
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < leng; i++) {
                if(name.charAt(i) != 'A') {
                    list.add(i);
                    if(start == 0) {
                        start = i;
                    }
                    end = i;
                    
                    if(name.charAt(i) - 'A' <= 'Z' - name.charAt(i) + 1) {
                        answer += name.charAt(i) - 'A';
                    } else {
                        answer += 'Z' - name.charAt(i) + 1;
                    }
                }
            }
            
            System.out.println(answer);
            
            Collections.sort(list);
            System.out.println(list);
            
            int min = end;
            // 이동방법
            for(int i = 0; i < list.size() - 1; i++) {
                int begin = list.get(i);
                
                if(begin + begin + name.length() - list.get(i+1) < min) {
                    min = begin + begin + name.length() - list.get(i+1);
                }
            }
            
            for(int i = list.size() - 1; i >= 1; i--) {
                int begin = name.length() - list.get(i);
                
                if(begin + begin + list.get(i-1) < min) {
                    min = begin + begin + list.get(i-1);
                }
            }
            
            System.out.println(min);
            
            answer += min;
            
            return answer;
        }
    }
}