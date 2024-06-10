class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        freq.put(0,1);
        int ans = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            int rem = (sum % k + k) % k;
            ans = ans + freq.getOrDefault(rem , 0);
            freq.put(rem , freq.getOrDefault(rem , 0) + 1);
        }
        return ans;
    }
}