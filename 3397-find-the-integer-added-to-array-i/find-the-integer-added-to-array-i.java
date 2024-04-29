class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int min_nums1 = Integer.MAX_VALUE;
        int min_nums2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums1.length ; i++){
            min_nums1 = Math.min(nums1[i],min_nums1);
        }
        for(int i = 0; i < nums2.length ; i++){
            min_nums2 = Math.min(nums2[i],min_nums2);
        }
        return min_nums2 - min_nums1;
    }
}