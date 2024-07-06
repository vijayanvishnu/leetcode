class Solution {
    public long maximumPoints(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        int l = 0 , r = nums.length - 1;
        while(l <= r){
            ans = ans + k / nums[l];
            if(ans > 0){
                k = k % nums[l] + nums[r];
            }
            r--;
        }
        return ans;
    }
}