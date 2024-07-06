class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int nums[] = new int[2 * n ];
        for(int i = 0 ; i < n ; i++){
            nums[i] = nums[i + n] = colors[i];
        }
        int l = 0 , r = 0, ans = 0;
        while(l < n){
            if(r == l){
                if(r + 1 < nums.length && nums[r] != nums[r + 1]){
                    r++;
                }else{
                    l = ++r;
                }
            }else{
                if(r - l == k - 1){
                    l++;
                    ans++;
                }else{
                    if(r + 1 < nums.length && nums[r] != nums[r + 1]){
                        r++;
                    }else{
                        l++;
                    }
                }
            }
            // System.out.println(l + " " + r);
        }
        return ans;
    }
}