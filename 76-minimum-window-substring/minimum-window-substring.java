class Solution {
    private boolean mapMatch(HashMap<Character,Integer> copy,HashMap<Character,Integer> ori){
        for(char i : ori.keySet()){
            if(copy.containsKey(i) && copy.get(i) >= ori.get(i)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>();
        int size = t.length();
        for(int i=0;i<size;i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int minLen = Integer.MAX_VALUE;
        String minRes = new String("");
        size = s.length();
        int left = 0;
        int right = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(right<size){
            if(mapMatch(map,tmap)){
                if(minLen > (right-left+1)){
                    minRes = s.substring(left,right);
                    minLen = right - left + 1;
                }
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            else{
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
                right++;
            }
        }
        while(mapMatch(map,tmap)){
            if(minLen > (right-left+1)){
                minRes = s.substring(left,right);
                minLen = right - left + 1;
            }
            map.put(s.charAt(left),map.get(s.charAt(left))-1);
            if(map.get(s.charAt(left))==0){
                map.remove(s.charAt(left));
            }
            left++;
        }
        return minRes;
    }
}