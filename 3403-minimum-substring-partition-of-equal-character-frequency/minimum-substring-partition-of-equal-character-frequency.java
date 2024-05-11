class Solution {
    public int minimumSubstringsInPartition(String s) {
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp,Integer.MAX_VALUE >> 1);
        dp[s.length()] = 0;
        for(int i = s.length() - 1 ; i > -1 ; i--){
            int hash[] = new int[26];
            for(int j = i ; j < s.length() ; j++){
                int key = s.charAt(j) - 'a';
                hash[key]++;
                int f = -1;
                boolean found = true;
                for(int k : hash){
                    if(k == 0){
                        continue;
                    }
                    if(f == -1){
                        f = k;
                        continue;
                    }
                    if(f != k){
                        found = false;
                        break;
                    }
                }
                if(found){
                    dp[i] = Math.min(dp[i] , 1 + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}