class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int ptr = k;
        int ans = 1;
        while(ptr < word.length()){
            int start = 0;
            int t = ptr;
            while(ptr < word.length()){
                if(word.charAt(ptr) == word.charAt(start)){
                    start++;
                    ptr++;
                }else{
                    break;
                }
            }
            if(ptr == word.length()){
                return ans;
            }
            ptr = t + k;
            ans++;
        }
        return ans;
    }
}