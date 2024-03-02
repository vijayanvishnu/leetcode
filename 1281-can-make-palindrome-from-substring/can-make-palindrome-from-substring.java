class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int hash[][] = new int[s.length() + 1][26];
        for(int i = 0 ; i < s.length() ; i++){
            int key = s.charAt(i) - 'a';
            if(i != 0){
                for(int j = 0 ; j < 26 ; j++){
                    hash[i + 1][j] = hash[i][j];
                }
            }
            hash[i + 1][key]++;
        }
        for(int i = 0 ; i < queries.length ; i++){
            int left = queries[i][0];
            int right = queries[i][1] + 1;
            int change = queries[i][2];
            int len = right - left;
            int max = 0;
            int rem = 0;
            for(int j = 0; j < 26 ; j++){
                int cnt = hash[right][j] - hash[left][j];
                if((cnt&1) == 0){
                    max = max + cnt;
                }else{
                    max = max + cnt - 1;
                    rem++;
                }
            }
            if((rem&1) == 1){
                max++;
                rem--;
            }
            max = max + Math.min(2 * change , rem);
            if(max == len){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
}