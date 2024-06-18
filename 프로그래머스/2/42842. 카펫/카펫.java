import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 가로 >= 세로
        // 1. yellow의 약수 구하기 -> 세로만 구하면 됨
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if(yellow % i == 0) list.add(i);
        }
        
        // brown의 갯수 = (yellow 가로 + 2) * (yellow 세로 + 2) - yellow 넓이
        // = 2 * (yellow 가로 + yellow 세로) + 4
        
        // 카펫의 가로 : yellow가로 + 2
        // 카펫의 세로 : yellow세로 + 2
        // System.out.println(list);
        // 여기서 num은 yellow의 세로
        for(int num : list) {
            if(2 * (num + (yellow/num)) + 4 == brown) {
                answer[0] = yellow/num + 2;
                answer[1] = num + 2;
            }
        }
        
        
        return answer;
    }
}