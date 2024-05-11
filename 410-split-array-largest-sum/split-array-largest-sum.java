class Solution {
    private int helper(int nums[],int sum){
        int k = 1;
        int curr = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(curr + nums[i] < sum){
                curr = curr + nums[i];
            }else{
                curr = nums[i];
                k++;
            }
        }
        return k;
    }
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 1_000_000_001;
        int ans = -1;
        while(left <= right){
            int mid = (left + right) / 2;
            int count = helper(nums,mid);
            if(count <= k){
                right = mid - 1;
                if(count == k){
                    if(ans == -1){
                        ans = mid;
                    }
                    ans = Math.min(ans,mid);
                }
            }else{
                left = mid + 1;
            }
        }
        int res = 0;
        int curr = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(curr + nums[i] < ans){
                curr = curr + nums[i];
            }else{
                curr = nums[i];
                k++;
            }
            res = Math.max(curr,res);
        }
        return res;
    }
}