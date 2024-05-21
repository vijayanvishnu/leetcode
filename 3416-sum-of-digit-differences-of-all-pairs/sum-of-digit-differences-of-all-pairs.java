class Solution {
    public long sumDigitDifferences(int[] nums) {
        long freq[][] = new long[10][10];
        for(int i = 0; i < nums.length ; i++){
            int idx = 0;
            int t = nums[i];
            while(t > 0){
                freq[idx][t%10]++;
                t/=10;
                idx++;
            }
        }
        long ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int idx = 0;
            int t = nums[i];
            int n = nums.length - i;
            while(t > 0){
                ans = ans + Math.abs(n - freq[idx][t%10]);
                freq[idx][t%10]--;
                idx++;
                t/=10;
            }
        }
        return ans;
    }
}