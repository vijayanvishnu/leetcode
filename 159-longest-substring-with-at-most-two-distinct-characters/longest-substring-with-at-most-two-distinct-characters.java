class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> pos = new HashMap<>();
        int ans = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(pos.size() <= 2){
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
            if(pos.size() < 3){
                ans = Math.max(ans , right - left);
            }
        }
        return ans;
    }
}