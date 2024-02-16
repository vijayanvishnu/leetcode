class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character,Integer> pos = new HashMap<>();
        int ans = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(pos.size() <= k){
                char key = s.charAt(right);
                pos.put(key,right);
                right++;
            }else{
                char key = s.charAt(left);
                if(pos.get(key) == left){
                    pos.remove(key);
                }
                left++;
            }
            if(pos.size() <= k){
                ans = Math.max(ans , right - left);
            }
        }
        return ans;
    }
}