class Solution {
    public int maxOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 1 ; i < nums.length ; i+= 2){
            map.put(nums[i-1] + nums[i] , map.getOrDefault(nums[i-1] + nums[i] , 0 ) + 1);
            if(map.size() == 2) break;
        }
        int max = 0;
        for(int i : map.values()){
            max = Math.max(i,max);
        }
        return max;
    }
}