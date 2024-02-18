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
        PriorityQueue<int []> emptyQueue = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1], b[1]);
        });
        for(int i = 0; i < n ; i++){
            emptyQueue.add(new int[]{0,i});
        }
        while(!meets.isEmpty()){
            while(!queue.isEmpty() && queue.peek()[0] <= meets.peek()[0] ){
                long poll[] = queue.poll();
                emptyQueue.add(new int[]{0,(int) poll[1]});
            }
            if(!emptyQueue.isEmpty()){
                int poll[] = emptyQueue.poll();
                poll[0] = meets.poll()[1];
                rooms[poll[1]]++;
                queue.add(new long[]{poll[0],poll[1]});
            }else{
                long poll[] = queue.poll();
                poll[0] = poll[0] + meets.peek()[1]  - meets.poll()[0];
                rooms[(int) poll[1]]++;
                queue.add(poll);
            }
        }
        int max = 0;
        int ans = 0;
        for(int i = 0; i < n ; i ++){
            System.out.println(rooms[i]);
            if(rooms[i] > max){
                max = rooms[i];
                ans = i;
            }
        }
        return ans;
    }
}