class Solution {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long sum = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
            int res = Integer.compare(a[0],b[0]);
            if(res != 0) return res;
            return Integer.compare(a[1],b[1]);
        });
        boolean visited[] = new boolean[nums.length];
        long res[] = new long[queries.length];
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            pq.add(new int[]{nums[i],i});
        }
        for(int i = 0; i < queries.length ; i++){
            int idx = queries[i][0];
            if(!visited[idx]){
                visited[idx] = true;
                sum -= nums[idx];
            }
            for(int j = 0; j < queries[i][1] ; j++){
                int poll[] = pq.poll();
                if(poll ==  null){
                    res[i] = sum;
                    continue;
                }
                if(visited[poll[1]]){
                    j--;
                }else{
                    sum -= poll[0];
                    visited[poll[1]] = true; 
                }
            }
            res[i] = sum;
        }
        return res;
    }
}