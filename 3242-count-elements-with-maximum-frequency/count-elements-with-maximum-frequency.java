class Solution {
    public int maxFrequencyElements(int[] nums) {
        int hash[] = new int[101];
        int max = 0;
        for(int i : nums){
            hash[i]++;
            max = Math.max(max,hash[i]);
        }
        int ans = 0;
        for(int i = 0; i < 101 ; i++){
            if(max == hash[i]){
                ans = ans + hash[i];
            }
        }
        return ans;
    }
}