class Solution {
    public String solution(int[] food) {
        
        String ans = "";
        int[] refactor = new int[food.length];
        
        // 먼저 나누기 + 앞에서부터 먹는 사람
        for(int i = 1; i < food.length; i++) {
            refactor[i] = food[i] / 2;
            
            for(int l = 0; l < refactor[i]; l++) {
                ans += i;
            }
        }
        
        // 물
        ans += 0;
        
        // 뒤에서부터 먹는 사람
        for(int i = refactor.length - 1; i >= 1; i--) {
            for(int l = 0; l < refactor[i]; l++) {
                ans += i;
            }
        }
        
        return ans;
    }
}