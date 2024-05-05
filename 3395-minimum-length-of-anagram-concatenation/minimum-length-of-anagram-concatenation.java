class Solution {
    public int minAnagramLength(String s) {
        int hash[] = new int[26];
        int max = 0;
        for(char i : s.toCharArray()){
            int key = i - 'a';
            hash[key]++;
            max = Math.max(max,hash[key]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i <= max ; i ++){
            int curr = 0;
            int j = 0;
            for(j = 0 ; j < 26; j++){
                if(hash[j] % i == 0){
                    curr = curr + hash[j] / i;
                }else break;
            }
            if(j == 26){
                ans = Math.min(ans,curr);
            }
        }
        return ans;
    }
}