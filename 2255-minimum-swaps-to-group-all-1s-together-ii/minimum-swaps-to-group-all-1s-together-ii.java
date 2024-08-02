class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for(int i : nums){
            ones = ones + i;
        }
        int left = 0;
        int right = 0;
        int currOnes = 0;
        while(right < ones){
            currOnes = currOnes + nums[right];
            right++;
        }
        int ans , n = ans = 2 * nums.length;
        while(right < n){
            ans = Math.min(ans,ones - currOnes);
            int l = left % nums.length;
            int r = right % nums.length;
            currOnes -= nums[l];
            currOnes += nums[r];
            left++;
            right++;
        }
        ans = Math.min(ans,ones - currOnes);
        return ans;
    }
}