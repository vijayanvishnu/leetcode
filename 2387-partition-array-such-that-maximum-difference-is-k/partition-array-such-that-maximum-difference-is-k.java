class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int left , right = left = 0;
        int ans = 0;
        while(right < nums.length){
            while(right < nums.length && nums[right] - nums[left] <= k){
                right++;
            }
            left = right;
            ans++;
        }
        return ans;
    }
}