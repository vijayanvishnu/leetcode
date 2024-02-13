class Solution {
    private int[] getLPS(char str[]){
        int i = 1;
        int len = 0;
        int lps[] = new int[str.length];
        while(i < str.length){
            if(str[i] == str[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len == 0){
                    i++;
                }else{
                    len = lps[len-1];
                }
            }
        }
        return lps;
    }
    public int minimumTimeToInitialState(String word, int k) {
        int ans = 0;
        int n = word.length();
        int lps[] = getLPS(word.toCharArray());
        int last = lps[lps.length - 1];
        while(last > 0 && (lps.length - last) % k != 0){
            last = lps[last - 1];
        }
        return ((n - last) % k == 0) ? (n-last)/k : Math.ceilDiv(n-last, k);
    }
}