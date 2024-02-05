class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int prev = 0;
        int ans = 0;
        for(int i : nums){
            if(prev + i == 0){
                ans++;
            }
            prev += i;
        }
        return ans;
    }
}