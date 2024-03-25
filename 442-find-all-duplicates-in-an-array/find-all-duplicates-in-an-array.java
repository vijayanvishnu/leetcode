class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int hash[] = new int[1_00_001];
        for(int i = 0 ; i < nums.length ; i++){
            hash[nums[i]]++;
            if(hash[nums[i]] == 2){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}