import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();  // 여기에다가는 id랑 닉네임 저장(중복값 불가)
        Queue<String> queue = new LinkedList<>();   // 여기는 in / out 저장
        Queue<String> id = new LinkedList<>();      // 여기는 닉네임 반영을 위한 고유 id 저장
        
        for(int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            // System.out.println(Arrays.toString(info));
            
            if(info.length == 3) {
                // change랑 enter만 있는데, map 자료구조는 어차피 중복값 허용이 안되기 떄문에 덮어쓰기 가능이라 구분 X
                map.put(info[1], info[2]);  // key: id, value: nickname
            
                if(info[0].equals("Enter")) {
                    queue.add("님이 들어왔습니다.");
                    id.add(info[1]);
                }
                
            } else {    // Leave일 때
                queue.add("님이 나갔습니다.");
                id.add(info[1]);
            }
            
        }
        
        
        // return 할 배열을 queue 크기만큼 선언 및 초기화
        String[] answer = new String[queue.size()];
            
        // queue에서 하나씩 뽑으면서 값을 입력
        int idx = 0;
        while(!queue.isEmpty()) {
            String user = id.poll();
            String behavior = queue.poll();
                
            answer[idx] = map.get(user) + behavior;
            idx++;
        }
        
        return answer;
    }
}