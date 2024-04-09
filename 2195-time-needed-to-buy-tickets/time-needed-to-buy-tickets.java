class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int req = tickets[k];
        for(int i = 0 ; i <= k ; i++){
            ans = ans + Math.min(req,tickets[i]);
        }
        req = Math.max(0,req-1);
        for(int i = k + 1 ; i < tickets.length ; i++){
            ans = ans + Math.min(req,tickets[i]);
        }
        return ans;
    }
}