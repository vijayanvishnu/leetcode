class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int rooms[] = new int[n];
        PriorityQueue<int []> meets = new PriorityQueue<>((a,b)->{
            int ans = Integer.compare(a[0],b[0]);
            if(ans != 0) return ans;
            return Integer.compare(a[1], b[1]);
        });
        for(int i[] : meetings){
            meets.add(i);
        }
        PriorityQueue<long []> queue = new PriorityQueue<>((a,b)->{
            int ans = Long.compare(a[0],b[0]);
            if(ans != 0) return ans;
            return Long.compare(a[1], b[1]);
        });
        PriorityQueue<long []> emptyQueue = new PriorityQueue<>((a,b)->{
            return Long.compare(a[1], b[1]);
        });
        for(long i = 0; i < n ; i++){
            emptyQueue.add(new long[]{0,i});
        }
        while(!meets.isEmpty()){
            while(!queue.isEmpty() && queue.peek()[0] <= meets.peek()[0] && queue.peek()[0] != 0 ){
                long poll[] = queue.poll();
                poll[0] = 0;
                emptyQueue.add(poll);
            }
            if(emptyQueue.isEmpty()){
                long poll[] = queue.poll();
                emptyQueue.add(poll);
            }
            long poll[] = emptyQueue.poll();
            if(rooms[(int)poll[1]] == 0 || meets.peek()[0] >= poll[0]){
                poll[0] = meets.poll()[1];
            }else{
                poll[0] = poll[0] - meets.peek()[0] + meets.poll()[1];
            }
            rooms[(int)poll[1]]++;
            queue.add(poll);
        }
        int max = 0;
        int ans = 0;
        for(int i = 0; i < n ; i ++){
            if(rooms[i] > max){
                max = rooms[i];
                ans = i;
            }
        }
        return ans;
    }
}