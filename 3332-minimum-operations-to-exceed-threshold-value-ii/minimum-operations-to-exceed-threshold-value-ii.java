class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i = 0; i < nums.length ; i++){
            q.add((long)nums[i]);
        }
        int ans = 0;
        while(!q.isEmpty() && q.peek() < k){
            long pop = q.poll();
            long ano = pop;
            ans++;
            if(!q.isEmpty()){
                ano = q.poll();
                q.add(Math.min(ano,pop) * 2 + Math.max(ano,pop));
            }
        }
        return ans;
    }
}