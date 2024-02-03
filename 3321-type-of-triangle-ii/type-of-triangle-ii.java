class Solution {
    public String triangleType(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i : nums){
            set.add(i);
        }
        if(nums[0] + nums[1] <= nums[2] || nums[2]+nums[1]  <= nums[0] || nums[0] + nums[2] <= nums[1]){
            return "none";
        }
        if(set.size() == 1){
            return "equilateral";
        }else if(set.size() == 2){
            return "isosceles";
        }else{
            return "scalene";
        }
    }
}