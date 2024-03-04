class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0;
        int left = 0;
        int right = tokens.length - 1;
        int curr = 0;
        while(left <= right){
            if(tokens[left] <= power){
                power -= tokens[left];
                curr++;
                left++;
                ans = Math.max(curr,ans);
            }else{
                if(curr > 0){
                    curr--;
                    power += tokens[right];
                    right--;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}