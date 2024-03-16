class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        int zero = 0;
        int one = 0;
        int ans = 0;
        freq.put(0,-1);
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 0){
                zero++;
            }else{
                one++;
            }
            freq.putIfAbsent(one - zero , i);
            ans = Math.max(i - freq.get(one - zero),ans);
        }
        return ans;
    }
}