class Solution {
    public int longestPalindrome(String s) {
        int hash[] = new int[126];
        for(int i = 0 ; i < s.length() ; i++){
            int key = s.charAt(i);
            hash[key]++;
        }
        int odd = 0;
        int ans = 0;
        for(int i = 0 ; i < 126 ; i++){
            if(hash[i] % 2 == 0){
                ans = ans + hash[i];
            }else{
                ans = ans + hash[i] - 1;
                odd++;
            }
        }
        if(odd > 0){
            ans++;
        }
        return ans;
    }
}