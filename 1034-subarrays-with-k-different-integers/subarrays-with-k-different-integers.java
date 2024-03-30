class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer,LinkedList<Integer>> freq = new HashMap<>();
        int r = 0;
        int l = 0;
        int max = Integer.MAX_VALUE;
        int ans = 0;
        while(r < nums.length){
            if(freq.size() < k){
                freq.putIfAbsent(nums[r],new LinkedList<>());
                freq.get(nums[r]).add(r);
                if(freq.size() == k){
                    max = r;
                }
                r++;
            }else if(freq.size() == k){
                if(freq.containsKey(nums[r])){
                    freq.get(nums[r]).add(r);
                    r++;
                }else{
                    // code that count
                    while(l<r  && freq.size() == k){
                        int val = nums[l];
                        ans = ans + r - max;
                        LinkedList<Integer> freqList = freq.get(nums[l]);
                        freqList.pollFirst();
                        if(freqList.size() == 0){
                            freq.remove(val);
                        }else{
                            max = Math.max(max,freqList.peekFirst());
                        }
                        l++;
                    }
                }
            }
        }
        while(l<r  && freq.size() == k){
            int val = nums[l];
            ans = ans + r - max;
            LinkedList<Integer> freqList = freq.get(nums[l]);
            freqList.pollFirst();
            if(freqList.size() == 0){
                freq.remove(val);
            }else{
                max = Math.max(max,freqList.peekFirst());
            }
            l++;
        }
        return ans;
    }
}