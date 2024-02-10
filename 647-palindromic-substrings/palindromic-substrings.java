class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        // odd length
        for(int i = 0 ; i < s.length() ; i++){
            int left = i;
            int right = i;
            while(left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        // even length
        for(int i = 1 ; i < s.length() ; i++){
            int left = i - 1;
            int right = i;
            while(left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}