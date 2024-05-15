class Solution {
    public boolean increasingTriplet(int[] nums) {
        long fMin = Long.MAX_VALUE , sMin = fMin , max = sMin;
        for(int i : nums){
            if(fMin >= i){
                fMin =i;
            }else if(sMin >= i){
                sMin = i;
            }else{
                if(fMin != max && sMin < i){
                    return true;
                }
            }
        }
        return false;
    }
}