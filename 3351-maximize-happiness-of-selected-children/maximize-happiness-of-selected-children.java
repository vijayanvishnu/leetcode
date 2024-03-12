class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        Arrays.sort(happiness);
        int dec = 0;
        int idx = happiness.length - 1;
        while(idx > -1 && k > 0){
            int t = happiness[idx] - dec;
            if(t > 0){
                ans = ans + t;
            }
            dec++;
            idx--;
            k--;
        }
        return ans;
    }
}