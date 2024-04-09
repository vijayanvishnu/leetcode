class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        if(nums[mid] == k){
            return 0;
        }else if(nums[mid] > k){
            long ops = nums[mid] - k;
            nums[mid] = k;
            int i = mid - 1;
            while(i > -1){
                if(nums[i] > nums[i + 1]){
                    ops = ops - nums[i + 1] + nums[i];
                    nums[i] = nums[i + 1];
                }else{
                    break;
                }
                i--;
            }
            return ops;
        }else{
            long ops = k - nums[mid];
            nums[mid] = k;
            int i = mid + 1;
            while(i < nums.length){
                if(nums[i] < nums[i - 1]){
                    ops = ops + nums[i - 1] - nums[i];
                    nums[i] = nums[i - 1];
                }else{
                    break;
                }
                i++;
            }
            return ops;
        }
    }
}