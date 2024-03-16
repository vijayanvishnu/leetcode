class Solution {
    public int[] productExceptSelf(int[] nums) {
        int leftArr[]=new int[nums.length];
        int rightArr[]=new int[nums.length];
        leftArr[0]=1;
        int n=nums.length;
        for(int i=1;i<nums.length;i++){
            leftArr[i]=leftArr[i-1]*nums[i-1];
        }
        rightArr[n-1]=1;
        for(int i=n-2;i>=0;i--){
            rightArr[i]=rightArr[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            leftArr[i]*=rightArr[i];
        }
        return leftArr;
    }
}