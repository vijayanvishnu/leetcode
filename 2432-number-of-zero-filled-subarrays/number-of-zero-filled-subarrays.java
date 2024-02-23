class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int idx = 0;
        while(idx < nums.length){
            long count = 0;
            while(idx < nums.length && nums[idx] == 0){
                count++;
                idx++;
            }
            if(count == 0){
                idx++;
            }
            ans = ans + (count * (count + 1))/2;
        }
        return ans;
    }
}