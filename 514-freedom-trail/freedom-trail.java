class Solution {
    Integer dp[][];
    int size;
    private int helper(List<Integer> hash[],int prev,char str[],int idx){
        if(idx == str.length){
            return 0;
        }
        if(dp[prev][idx] != null){
            return dp[prev][idx];
        }
        int ans = Integer.MAX_VALUE / 2;
        int key = str[idx] - 'a';
        for(int i : hash[key]){
            int f , s = f = Integer.MAX_VALUE;
            if(prev < i){
                f = i - prev;
                s = size + prev - i;
            }else{
                f = prev - i;
                s = size + i - prev;
            }
            ans = Math.min(ans,Math.min(f,s) + helper(hash,i,str,idx + 1));
        }
        return dp[prev][idx] = ans;
    }
    public int findRotateSteps(String ring, String key) {
        List<Integer> hash[] = new List[26];
        size = ring.length();
        dp = new Integer[101][101];
        for(int i = 0 ; i < hash.length ; i++){
            hash[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < ring.length() ; i++){
            int k = ring.charAt(i) - 'a';
            hash[k].add(i);
        }
        int ans = helper(hash,0,key.toCharArray(),0) + key.length();
        return ans;
    }
}