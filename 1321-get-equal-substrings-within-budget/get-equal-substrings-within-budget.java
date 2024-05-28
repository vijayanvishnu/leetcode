class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int n = s.length();
        int right = 0;
        int curr = 0;
        int ans = 0;
        while(right < n){
            if(curr <= maxCost){
                ans = Math.max(ans,right - left);
                curr = curr + Math.abs(s.charAt(right) - t.charAt(right));
                right++;
            }else{
                curr = curr - Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
        }
        while(left < n){
            if(curr <= maxCost){
                ans = Math.max(ans,right - left);
            }
            curr = curr - Math.abs(s.charAt(left) - t.charAt(left));
            left++;
        }
        return ans;
    }
}