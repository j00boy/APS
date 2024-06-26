import java.util.*;

class Solution {
    
    static char[] sel;
    static Map<String, Integer> map;
    static List<String> list;
    static int len;
    static int max;
    
    public List<String> solution(String[] orders, int[] course) {
        list = new ArrayList<>();
        
        for(int i = 0; i < course.length; i++) {
            max = 0;
            len = course[i];
            sel = new char[len];
            map = new HashMap<>();
            
            for(int j = 0; j < orders.length; j++) {
                char[] charArr = orders[j].toCharArray();
                Arrays.sort(charArr);
                combination(0, 0, charArr);
            }
            
            // System.out.println(map);
            
            if(max < 2) {
                continue;
            }
            List<String> keyList = new ArrayList<>(map.keySet());
            for(String ss : keyList) {
                if(map.get(ss) == max) {
                    list.add(ss);
                }
            }
            
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    public void combination(int sidx, int idx, char[] arr) {
        if(sidx >= sel.length) {
            // 여기서 map에 넣거나, value 변경
            // System.out.println(Arrays.toString(sel));
            String res = "";
            for(char ch : sel) {
                res += ch;
            }
            
            if(map.containsKey(res)) {
                int cnt = map.get(res);
                map.put(res, cnt + 1);
                // System.out.println(map);
                if(max < cnt + 1) {
                    max = cnt + 1;
                }
            } else {
                map.put(res, 1);
                // System.out.println(map);
            }
            return;
        }
        
        if(idx >= arr.length) {
            return;
        }
        
        sel[sidx] = arr[idx];
        combination(sidx + 1, idx + 1, arr);
        combination(sidx, idx + 1, arr);
    }
}