class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int ans = 0;
        ArrayDeque<Integer> minq = new ArrayDeque<>();
        ArrayDeque<Integer> maxq = new ArrayDeque<>();
        while(right < nums.length){
            int f , s , abs = f = s = 0;
            if(minq.peekFirst() != null){
                s = minq.peekFirst();
            }
            if(maxq.peekFirst() != null){
                f = maxq.peekFirst();
            }
            abs = s - f;
            if(abs <= limit){
                // System.out.println(abs);
                ans = Math.max(ans , right - left);
                while(minq.size() != 0 && minq.peekLast() < nums[right]){
                    minq.pollLast();
                }
                minq.offerLast(nums[right]);
                while(maxq.size() != 0 && maxq.peekLast() > nums[right]){
                    maxq.pollLast();
                }
                maxq.offerLast(nums[right]);
                right++;
            }else{
                if(minq.size() != 0 && minq.peekFirst() == nums[left]){
                    minq.pollFirst();
                }
                if(maxq.size() != 0 && maxq.peekFirst() == nums[left]){
                    maxq.pollFirst();
                }
                left++;
            }
            // System.out.println(minq);
            // System.out.println(maxq);
            // System.out.println(left + " " + right);
            // System.out.println("---------");
        }
        while(left < nums.length){
            int f , s , abs = f = s = 0;
            if(minq.peekFirst() != null){
                s = minq.peekFirst();
            }
            if(maxq.peekFirst() != null){
                f = maxq.peekFirst();
            }
            abs = s - f;
            if(abs <= limit){
                ans = Math.max(ans , right - left);
            }
            if(minq.size() != 0 && minq.peekFirst() == nums[left]){
                minq.pollFirst();
            }
            if(maxq.size() != 0 && maxq.peekFirst() == nums[left]){
                maxq.pollFirst();
            }
            left++;
        }
        return ans;
    }
}