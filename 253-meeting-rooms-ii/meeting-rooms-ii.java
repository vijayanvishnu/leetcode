class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals , (a,b)  -> a[0]-b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i < intervals.length ; i++ ){
            if(!q.isEmpty() && q.peek() <= intervals[i][0]){
                q.poll();
            }
            q.add(intervals[i][1]);
        }
        return q.size();
    }
}