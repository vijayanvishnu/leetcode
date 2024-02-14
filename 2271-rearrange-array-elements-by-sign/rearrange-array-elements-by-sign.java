class Solution {
    public int[] rearrangeArray(int[] nums) {
        int plus = 0;
        int minus = 1;
        int res [] = new int[nums.length];
        for(int itr = 0;itr<nums.length;itr++){
            if(nums[itr]<0){
                res[minus]=nums[itr];
                minus+=2;
            }
            else{
                res[plus]=nums[itr];
                plus+=2;
            }
        }
        return res; 
    }
}