class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < s.length() ; i++){
            sb = new StringBuilder();
            sb.append(s.charAt(i));
            sb.append(s.charAt(i - 1));
            if(s.contains(sb.toString())) return true;
        }
        return false;
    }
}