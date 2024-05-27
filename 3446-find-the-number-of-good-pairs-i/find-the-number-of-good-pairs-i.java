class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        Map<Integer,Integer> nums2Freq = new HashMap<>();
        for(int i : nums2){
            nums2Freq.putIfAbsent(i,0);
            nums2Freq.put(i,nums2Freq.get(i) + 1);
        }
        for(int i = 0 ; i < nums1.length ; i++){
            int div = 1;
            int curr = nums1[i] / k;
            if(curr == 0 || nums1[i] % k != 0){
                continue;
            }
            while(div * div < curr){
                if(curr % div == 0){
                    ans = ans + nums2Freq.getOrDefault(div,0);
                    ans = ans + nums2Freq.getOrDefault(curr / div,0);
                }
                div++;
            }
            if(div * div == curr){
                ans = ans + nums2Freq.getOrDefault(div,0);
            }
        }
        return (int) ans;
    }
}