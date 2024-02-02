class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        int freq[] = new int[26];
        for(int i = 0; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']++; 
        }
        int myK = 0;
        int odd = 0;
        for(int i = 0 ; i < 26 ; i ++){
            myK = myK + freq[i] / 2;
            odd += (freq[i] = freq[i] & 1);
        }
        if(odd > k){
            return false;
        }
        if(myK + odd >= k){
            return true;
        }else{
            while(myK + odd < k){
                myK--;
                odd+=2;
            }
            if(myK + odd == k){
                return true;
            }
        }
        return false;
    }
}