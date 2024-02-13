class Solution {
    private int[] getLPS(int nums[]) {
        int lps[] = new int[nums.length];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < nums.length) {
            if (nums[i] == nums[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

    public int countMatchingSubarrays(int[] nums1, int[] pattern) {
        int nums[] = new int[nums1.length - 1];
        for(int i = 1 ; i < nums1.length ; i++){
            nums[i- 1] = Integer.compare(nums1[i], nums1[i-1]);
        }
        int lps[] = getLPS(pattern);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < nums.length) {
            if (nums[i] == pattern[j]) {
                i++;
                j++;
            }
            else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
            if (j == pattern.length) {
                ans++;
                j = lps[j - 1];
            }
        }
        return ans;
    }
}
