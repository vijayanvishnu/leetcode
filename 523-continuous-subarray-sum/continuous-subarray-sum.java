class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> rems = new HashMap<>();
        int sum = 0;
        rems.put(0,-1);
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            int rem = sum % k;
            if(rems.containsKey(rem)){
                int get = rems.get(rem);
                if(i - get >= 2){
                    return true;
                }
            }else{
                rems.put(rem,i);
            }
            sum = rem;
        }
        return false;
    }
}