class Solution {
    private boolean oneDiff(String s,String t){
        int i = s.length();
        int cnt = 0;
        while(i > 0){
            if(s.charAt(i - 1) == t.charAt(i)){
                cnt++;
            }
            i--;
        }
        if(cnt == s.length()) return true;
        i = 1;
        int pref = 0;
        while(i < t.length()){
            if(s.charAt(i - 1) == t.charAt(i - 1)){
                pref++;
            }else{
                break;
            }
            if(s.charAt(i - 1) == t.charAt(i)){
                cnt--;
            }
            if(cnt + pref + 1 == t.length()){
                return true;
            }
            i++;
        }
        return false;
    }
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        if(s.length() == t.length()){
            int diff = 0;
            for(int i = 0; i < s.length() ; i++){
                if(s.charAt(i) != t.charAt(i)) diff++;
            }
            if(diff == 1) return true;
        }
        if(s.length() - t.length() == 1){
            if(oneDiff(t, s)) return true;
        }
        if(t.length() - s.length() == 1){
            if(oneDiff(s, t)) return true;
        }
        return false;
    }
}