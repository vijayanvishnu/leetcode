class Solution {
    public String frequencySort(String s) {
        StringBuffer out = new StringBuffer();
        int max=0;
        int hash[]=new int[128];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]++;
        }
        for(int i=0;i<s.length();i++){
            max=0;
            for(int j=47;j<128;j++){
                if(hash[max]<hash[j]){
                    max=j;
                }
            }
            if(hash[max]==0) break;
            for(int j=0;j<hash[max];j++){
                out.append((char)max);
            }
            hash[max]=0;
        }
        return out.toString();
    }
}