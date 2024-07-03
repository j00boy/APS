import java.util.*;
import java.math.*;

class Solution {
    public int solution(int n, int k) {
        int count = 0;
        /*
        
        // 1. 정수 n을 k진수로 바꾸기
        // 3^13 = 1,594,323
        int[] convert = new int[13];
        // Arrays.fill(convert, -1);
        int idx = 0;
        int max_len = 0;

        while(n != 0) {

            int tmp = 1;
            int len = 0;
            
            while(n >= tmp) {
                tmp *= k;
                len++;
            }
            
            if(max_len == 0) {
                max_len = len;
            }
            
            idx = 12 - len;
            
            // System.out.println("전: " + n);
            convert[idx] = n / (int) Math.pow(k, len-1);
            n = n % (int) Math.pow(k, len-1);
            // System.out.println("후: " + n);
        }
        
        for(int i = 0; i <= max_len; i++) {
            if(convert[i] == -1) {
                convert[i] = 0;
            }
        }
        
        // 소수 판정
        String str = "";
        for(int i = 12 - max_len; i < 12; i++) {
            str += convert[i];
        }
        
        String[] strArr = str.split("0");
        // System.out.println(Arrays.toString(strArr));
        
        */
        
        String str = Integer.toString(n, k);
        System.out.println(str);
        String[] strArr = str.split("0");
        
        for(String num : strArr) {
            if(num.equals("") || num.equals(" ")) {
                continue;
            }
            
            long toLong = Long.parseLong(num);
            if(isPrime(toLong)) {
                count++;
            }
        }
        
        
        // System.out.println(Arrays.toString(convert));
        // System.out.println(max_len);
        // System.out.println(str);
        
        
        return count;
    }
    
    public boolean isPrime(long num) {
        if(num < 2) {
            return false;
        } else if(num == 2) {
            return true;
        } else {
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}