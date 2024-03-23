class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int idx = nums.length - 2;
        int ptr = nums.length - 1;
        while(idx > -1){
            ans = Math.max(ans,nums[idx] + nums[ptr] + idx - ptr);
            if(nums[ptr] - ptr < nums[idx] - idx){
                ptr = idx;
            }
            idx--;
        }
        return ans;
    }
}