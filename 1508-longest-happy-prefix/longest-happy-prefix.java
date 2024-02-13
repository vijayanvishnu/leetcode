class Solution {
    private int[] getLPS(char str[]){
        int lps[] = new int[str.length];
        int i = 1;
        int j = 0;
        while( i < str.length ){
            if(str[i] == str[j]){
                j++;
                lps[i] = j;
                i++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return lps;
    }
    public String longestPrefix(String s) {
        int lps[] = getLPS(s.toCharArray());
        if(lps[lps.length - 1] == 0) return "";
        return s.substring(0,lps[lps.length - 1]);
    }
}