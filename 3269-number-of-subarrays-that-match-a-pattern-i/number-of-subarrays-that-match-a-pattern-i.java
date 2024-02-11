class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int numsPat[] = new int[nums.length - 1];
        for(int i = 1 ; i < nums.length ; i++){
            numsPat[i-1] = Integer.compare(nums[i], nums[i - 1]);
        }
        int res = 0;
        for(int i = 0; i <= (numsPat.length - pattern.length) ; i++){
            boolean found = true;
            for(int j = 0 ; j < pattern.length ; j++){
                if(numsPat[i + j] != pattern[j]){
                    found = false;
                    break;
                }
            }
            if(found) res++;
        }
        return res;
    }
}