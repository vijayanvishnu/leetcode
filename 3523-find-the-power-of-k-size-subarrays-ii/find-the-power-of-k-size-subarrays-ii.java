class Solution {
    public int[] resultsArray(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < k ; i++){
            while(q.size() > 0 && (nums[q.peekLast()] >= nums[i] || nums[q.peekLast()] + 1 != nums[i])){
                q.pollLast();
            }
            q.addLast(i);
        }
        int ans[] = new int[nums.length - k + 1];
        Arrays.fill(ans,-1);
        for(int i = k ; i < nums.length ; i++){
            // System.out.println(q);
            if(q.size() == k){
                ans[i - k] = nums[q.peekLast()];
            }
            if(i - k == q.peekFirst()){
                q.pollFirst();
            }
            while(q.size() > 0 && (nums[q.peekLast()] >= nums[i] || nums[q.peekLast()] + 1 != nums[i])){
                q.pollLast();
            }
            q.addLast(i);
        }
        // System.out.println(q);
        if(q.size() == k){
            ans[ans.length - 1] = nums[q.peekLast()];
        }
        return ans;
    }
}