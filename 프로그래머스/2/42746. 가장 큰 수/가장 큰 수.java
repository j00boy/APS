import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] numbersToStr = new String[numbers.length];
        
        int count = 0;
        for(int i = 0; i < numbers.length; i++) {
            numbersToStr[i] = "" + numbers[i];
        }
        
        Arrays.sort(numbersToStr, new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2) {
                
                // 길이가 다를 때에는 문자열 내림차순으로 정렬하면 9534[30][3] 이 나옴
                // 길이가 다른 애들은 303이 나은지, 330이 나은지를 비교함
                if(s1.length() != s2.length()) {
                    String tmp1 = s1 + s2;
                    String tmp2 = s2 + s1;
                    
                    for(int i = 0; i < tmp1.length(); i++) {
                        // 자릿수가 다른 시점에서 크기를 비교
                        if(tmp1.charAt(i) != tmp2.charAt(i)) {
                            return tmp2.charAt(i) - tmp1.charAt(i);
                        }
                    }
                }
                
                // 길이가 같을 때는 상관이 없지만
                return s2.compareTo(s1);
            }
        });
        
        // System.out.println(Arrays.toString(numbersToStr));
        
        for(int i = 0; i < numbers.length; i++) {
            answer += numbersToStr[i];
        }
        
        if(answer.charAt(0) == '0') {
            answer = "0";
        }
        
        return answer;
    }
}