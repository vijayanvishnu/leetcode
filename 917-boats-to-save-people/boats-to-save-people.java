class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int boats = 0;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            boats++;
            if(nums[left]+nums[right]<=limit) left++;
            right--;
        }
        return boats;
    }
}