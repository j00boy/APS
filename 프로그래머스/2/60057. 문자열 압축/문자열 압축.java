import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(String s) {
        int len = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
            Map<String, Integer> map = new HashMap<>();
            String result = "";
            for(int j = 0; j < s.length(); j += i) {
                String tmp = "";
                for(int k = j; k < j + i; k++) {
                    if(k >= s.length()) {
                        break;
                    }
                    tmp += s.charAt(k);
                }
                
                if(!map.containsKey(tmp)) {
                    if(map.isEmpty()) {
                        map.put(tmp, 1); 
                    } else {    // 맵이 비어있지 않을 때 + 처음보는 키가 들어올 때
                        for(String key : map.keySet()) {
                            if(map.get(key).equals(1)) {
                                result += key;
                            } else {
                                result += map.get(key);
                                result += key;
                            }
                        }
                        map.clear();
                        map.put(tmp, 1);
                    }
                } else {
                    int num = map.get(tmp);
                    map.replace(tmp, num + 1);
                }
            }
            
            // System.out.println(result);
            
            for(String key : map.keySet()) {
                if(map.get(key).equals(1)) {
                    result += key;
                } else {
                    result += map.get(key);
                    result += key;
                }
                map.clear();
            }
            
            if(len > result.length()) {
                len = result.length();
                // System.out.println(result);
            }
        }
        
        
        return len;
    }
}