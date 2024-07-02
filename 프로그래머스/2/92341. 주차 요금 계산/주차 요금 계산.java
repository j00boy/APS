import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> answer = new HashMap<>();
        
        
        for(String record : records) {
            String[] arr = record.split(" ");
            
            String time = arr[0];
            String car_no = arr[1];
            String how = arr[2];
            
            if(how.equals("IN")) {
                map.put(car_no, time);
                if(!answer.containsKey(car_no)) {
                    answer.put(car_no, 0);
                }
            } else {
                // 시간 계산 후 누적값 자료구조에 저장
                String in_time = map.get(car_no);
                String[] inArr = in_time.split(":");
                String[] outArr = time.split(":");
                
                int total = 60 * Integer.parseInt(outArr[0]) + Integer.parseInt(outArr[1]) - 60 * Integer.parseInt(inArr[0]) - Integer.parseInt(inArr[1]);
                
                answer.put(car_no, answer.get(car_no) + total);
                map.remove(car_no);
            }
        }
        
         // 출차기록이 없으면 23:59에 나간 걸로 처리
        List<String> keys = new ArrayList<>(map.keySet());
        for(String key : keys) {
            String in_time = map.get(key);
            String[] inArr = in_time.split(":");
                
            int total = (60 * 23 + 59) - 60 * Integer.parseInt(inArr[0]) - Integer.parseInt(inArr[1]);
                
            answer.put(key, answer.get(key) + total);
            map.remove(key);
        }
        
        // System.out.println(answer);
        
        // Map 정렬
        // 1. TreeMap 자료구조로 변환 -> Comparator를 생략하면 기본 Comparator가 실행됨(사전순)
        Map<String, Integer> result = new TreeMap<>(answer);
        List<Integer> cars = new ArrayList<>();
        // System.out.println(result);
        for(String s : result.keySet()) {
            if(result.get(s) <= fees[0]) {
                result.replace(s, fees[1]);
            } else {
                if((result.get(s) - fees[0]) % fees[2] != 0) {
                    result.replace(s, fees[1] + ((result.get(s) - fees[0]) / fees[2] + 1) * fees[3]);
                } else {
                    result.replace(s, fees[1] + (result.get(s) - fees[0]) / fees[2] * fees[3]);
                }
            }
            cars.add(result.get(s));
        }
        
        // System.out.println(result);
        
        // List<Integer> cars = new ArrayList<>();
        
        return cars;
    }
}