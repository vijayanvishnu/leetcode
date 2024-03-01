class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') ones++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length()-1;i++){
            if(ones>1){
                sb.append('1');
                ones--;
            }
            else{
                sb.append('0');
            }
        }
        sb.append('1');
        return sb.toString();
    }
}