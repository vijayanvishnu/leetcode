class Solution {
    private boolean allMarked(int nums[],int idx[],int end){
        Set<Integer> set = new HashSet<>();
        List<int []> list = new ArrayList<>();
        for(int i = end ; i > -1 ; i--){
            if(!set.contains(idx[i])){
                set.add(idx[i]);
                list.add(new int[]{idx[i] , 1 + i});
            }
        }
        if(set.size() != nums.length){
            return false;
        }
        Collections.reverse(list);
        int rem = list.get(0)[1];
        int count = 1;
        if(rem < nums[list.get(0)[0]] + 1){
            return false;
        }else{
            rem -= nums[list.get(0)[0]] + 1;
        }
        for(int i = 1 ; i < list.size() ; i++){
            int values[] =  list.get(i);
            rem = rem - list.get(i - 1)[1] - 1 + values[1];
            if(rem >= nums[values[0]]){
                count++;
                rem -= nums[values[0]];
                // rem--;
            }
        }
        return count == nums.length ;
    }
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int ans = -1;
        for(int i = 0 ; i < changeIndices.length ; i++){
            changeIndices[i]--;
        }
        for(int i = 0; i < changeIndices.length ; i++){
            if(allMarked(nums,changeIndices,i)){
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}