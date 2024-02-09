class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int lis[][] = new int[nums.length][2];
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length ; i++){
            lis[i][0] = 1;
            lis[i][1] = -1;
            for(int j = i - 1 ; j > -1 ; j--){
                if(nums[i] % nums[j] == 0){
                    if(lis[i][0] < lis[j][0] + 1){
                        lis[i][0] = lis[j][0] + 1;
                        lis[i][1] = j;
                    }
                }
            }
            if(max < lis[i][0]){
                ans = new ArrayList<>();
                max = lis[i][0];
                int curr = i;
                while(curr != -1){
                    ans.add(nums[curr]);
                    curr = lis[curr][1];
                }
            }
        }
        return ans;
    }
}