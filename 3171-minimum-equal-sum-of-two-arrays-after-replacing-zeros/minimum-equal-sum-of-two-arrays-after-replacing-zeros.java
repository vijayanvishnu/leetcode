class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int z1, z2 = z1 = 0;
        long n1, n2 = n1 = 0;
        for (int i : nums1) {
            if (i == 0) {
                z1++;
            } else {
                n1 += i;
            }
        }
        for (int i : nums2) {
            if (i == 0) {
                z2++;
            } else {
                n2 += i;
            }
        }
        // System.out.println(n1 + " " + n2);
        long diff = 0;
        if(z1 == 0){
            if(n1 < z2 + n2){
                return -1;
            }
        }
        if(z2 == 0){
            if(n2 < z1 + n1){
                return -1;
            }
        }
        if (n1 >= n2) {
            diff = n1 - n2;
            return n2 + Math.max(diff + z1, z2);
        } else {
            diff = n2 - n1;
            return n1 + Math.max(diff + z2, z1);
        }
    }
}