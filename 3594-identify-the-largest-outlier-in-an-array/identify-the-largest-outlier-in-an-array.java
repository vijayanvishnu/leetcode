class Solution {
    public int getLargestOutlier(int[] nums) {
        long sum = 0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i : nums){
            sum = sum + i;
            countMap.put(i,countMap.getOrDefault(i,0) + 1);
        }
        int maxOut = Integer.MIN_VALUE;
        for(int i : nums){
            int currSum = (int) (sum - i);
            if(currSum % 2 == 0 && countMap.containsKey(currSum/2) && maxOut < i){
                if(i != currSum / 2){
                    maxOut = i;
                }else{
                    if(countMap.get(i) > 1){
                        maxOut = i;
                    }
                }
            }
        }
        return maxOut;
    }
}