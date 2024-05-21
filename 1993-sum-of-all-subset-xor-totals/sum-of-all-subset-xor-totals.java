class Solution {
    private int helper(int idx,int nums[],int curr){
        if(idx == nums.length){
            return curr;
        }
        int pick = helper(idx + 1, nums , curr ^ nums[idx]);
        int dont = helper(idx + 1, nums , curr);
        return pick + dont;
    }
    public int subsetXORSum(int[] nums) {
        return helper(0,nums,0);
    }
}