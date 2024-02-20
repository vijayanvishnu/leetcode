class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int reqSum = (size ) * (size + 1) / 2;
        int mySum = 0;
        for(int i : nums){
            mySum = mySum + i;
        }
        return reqSum - mySum;
    }
}