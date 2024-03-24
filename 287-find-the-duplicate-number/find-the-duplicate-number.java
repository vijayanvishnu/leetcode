class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int hash[]=new int[n];
        for(int i=0;i<n;i++){
            hash[nums[i]]++;
        }
        for(int i=0;i<n;i++){
            if(hash[i]>=2){
               return i;
            }
        }
        return 0;
    }
}