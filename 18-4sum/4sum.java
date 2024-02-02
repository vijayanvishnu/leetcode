class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int iLimit = nums.length-3;
        int jLimit = nums.length-2;
        for(int i=0;i<iLimit;i++){
            while(i > 0 && i < iLimit && nums[i] == nums[i-1]) i++;
            for(int j=i+1;j<jLimit;j++){
                while(j>i+1 && j < jLimit && nums[j] == nums[j-1]) j++;
                long sum = nums[i] + nums[j];
                long rSum = target - sum;
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    long s = nums[left] + nums[right];
                    if( s == rSum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        while(left<right && nums[left] == nums[left-1]){
                            left++;
                        }
                    }
                    else if( s > rSum ){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}