class Solution {
    private int divideAndConqure(int left , int right, long nums[]){
        if(left >= right){
            return 0;
        }
        int mid = (right - left) / 2 + left;
        int rightAns = divideAndConqure(mid + 1, right, nums);
        int leftAns = divideAndConqure(left, mid, nums);
        int ans = 0;
        int i = left;
        int j = mid + 1;
        while(j <= right && i <= mid){
            while(i <= mid && nums[j] * 2 >= nums[i]){
                i++;
            }
            ans = ans + Math.max(0,mid - i + 1);
            j++;
        }
        i = left;
        j = mid + 1;
        List<Long> list = new ArrayList<>();
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]){
                list.add(nums[i]);
                i++;
            }else{
                list.add(nums[j]);
                j++;
            }
        }
        while(i <= mid){
            list.add(nums[i]);
            i++;
        }
        while(j <= right){
            list.add(nums[j]);
            j++;
        }
        for(i = left ; i <= right ; i++){
            nums[i] = list.get(i-left);
        }
        return leftAns + rightAns + ans;
    }
    public int reversePairs(int[] nums) {
        long long_nums[] = new long[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            long_nums[i] = nums[i];
        }
        int ans = divideAndConqure(0, nums.length - 1, long_nums);
        return ans;
    }
}