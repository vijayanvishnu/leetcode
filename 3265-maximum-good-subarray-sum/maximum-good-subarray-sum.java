class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long pref[] = new long[nums.length + 1];
        long res = Long.MIN_VALUE;
        Map<Long,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            pref[i+1] = pref[i] + nums[i];
            if(!map.containsKey(nums[i]*1l)){
                map.put(nums[i]*1l, i);
            }else {
                if(pref[i] - pref[map.get(nums[i]*1l)] < 0){
                    map.put(nums[i] * 1l,i);
                }
            }
            if(map.containsKey(k*1l+nums[i])){
                res = Math.max(pref[i+1] - pref[map.get(k*1l + nums[i])],res);
            }
            if(map.containsKey(nums[i]*1l - k)){
                res = Math.max(pref[i+1] - pref[map.get(nums[i]*1l - k)],res);
            }
        }
        return res == Long.MIN_VALUE ? 0 : res;
    }
}