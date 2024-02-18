class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length ; i++){
            for(int j = 1 + i ; j  < words.length ; j++){
                if(words[i].length() <= words[j].length()){
                    if(words[j].substring(0,words[i].length()).equals(words[i]) && words[j].substring(words[j].length() - words[i].length()).equals(words[i])){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}