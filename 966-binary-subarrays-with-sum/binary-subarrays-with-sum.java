class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int ans = 0;
        Map<Integer,Integer> count = new HashMap<>();
        count.put(0,1);
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            ans = ans + count.getOrDefault(sum - goal,0);
            count.putIfAbsent(sum,0);
            count.put(sum,count.get(sum) + 1);
        }
        return ans;
    }
}