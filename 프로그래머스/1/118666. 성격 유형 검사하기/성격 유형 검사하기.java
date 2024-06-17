import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[][] mbti = new int[4][2]; // RT, CF, JM, AN
        
        for(int i = 0; i < survey.length; i++) {
            int score = Math.abs(4 - choices[i]);
            if(survey[i].equals("RT") || survey[i].equals("TR")) {
                if(survey[i].charAt(0) == 'R') {
                    if(4-choices[i] >= 0) {
                        mbti[0][0] += score;
                    } else {
                        mbti[0][1] += score;
                    }
                } else {
                    if(4-choices[i] >= 0) {
                        mbti[0][1] += score;
                    } else {
                        mbti[0][0] += score;
                    }
                }
            } else if(survey[i].equals("CF") || survey[i].equals("FC")) {
                if(survey[i].charAt(0) == 'C') {
                    if(4-choices[i] >= 0) {
                        mbti[1][0] += score;
                    } else {
                        mbti[1][1] += score;
                    }
                } else {
                    if(4-choices[i] >= 0) {
                        mbti[1][1] += score;
                    } else {
                        mbti[1][0] += score;
                    }
                }
            } else if(survey[i].equals("JM") || survey[i].equals("MJ")) {
                if(survey[i].charAt(0) == 'J') {
                    if(4-choices[i] >= 0) {
                        mbti[2][0] += score;
                    } else {
                        mbti[2][1] += score;
                    }
                } else {
                    if(4-choices[i] >= 0) {
                        mbti[2][1] += score;
                    } else {
                        mbti[2][0] += score;
                    }
                }
            } else {
                if(survey[i].charAt(0) == 'A') {
                    if(4-choices[i] >= 0) {
                        mbti[3][0] += score;
                    } else {
                        mbti[3][1] += score;
                    }
                } else {
                    if(4-choices[i] >= 0) {
                        mbti[3][1] += score;
                    } else {
                        mbti[3][0] += score;
                    }
                }
            }
        }
        
        for(int i = 0; i < 4; i++) {
            if(mbti[i][0] >= mbti[i][1]) {
                if(i == 0) {
                    answer += "R";
                } else if(i == 1) {
                    answer += "C";
                } else if(i == 2) {
                    answer += "J";
                } else {
                    answer += "A";
                }
            } else {
                if(i == 0) {
                    answer += "T";
                } else if(i == 1) {
                    answer += "F";
                } else if(i == 2) {
                    answer += "M";
                } else {
                    answer += "N";
                }
            }
        }
        
        return answer;
    }
}