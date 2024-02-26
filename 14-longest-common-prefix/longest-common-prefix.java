class Solution {
    private String getCommon(String s,String a){
        StringBuilder sb = new StringBuilder();
        int size = Math.min(a.length(),s.length());
        int i = 0;
        while(i < size){
            if(s.charAt(i) == a.charAt(i)){
                sb.append(s.charAt(i));
            }else{
                break;
            }
            i++;
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        String pref = strs[0];
        for(int i = 1 ; i < strs.length ; i++){
            pref = getCommon(pref,strs[i]);
        }
        return pref;
    }
}