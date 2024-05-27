class Solution {
    
    static int cnt = 0;
    
    public void makeExp(int result ,int idx ,int[] arr, int target) {
        
        if(idx == arr.length) {
            if(result == target) {
                cnt++;
            }
            return;
        }
        
        result += arr[idx];
        makeExp(result, idx + 1, arr, target);
        
        result -= arr[idx];
        result -= arr[idx];
        makeExp(result, idx + 1, arr, target);
        
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        makeExp(0, 0, numbers, target);
        
        return cnt;
    }
}