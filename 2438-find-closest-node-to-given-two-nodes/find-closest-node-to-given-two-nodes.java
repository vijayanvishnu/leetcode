class Solution {
    public int closestMeetingNode(int[] edges, int src, int dst) {
        Map<Integer,Integer> srcPath = new HashMap<>();
        Map<Integer,Integer> dstPath = new HashMap<>();
        int dis = 0;
        int curr = src;
        while(curr != -1 && !srcPath.containsKey(curr)){
            srcPath.put(curr,dis);
            curr = edges[curr];
            dis++;
        }
        curr = dst;
        dis = 0;
        while(curr != -1 && !dstPath.containsKey(curr)){
            dstPath.put(curr,dis);
            curr = edges[curr];
            dis++; 
        }
        int ans = -1;
        dis = Integer.MAX_VALUE;
        for(int i : srcPath.keySet()){
            if(dstPath.containsKey(i)){
                int sum = Math.max(srcPath.get(i) , dstPath.get(i));
                // System.out.println(sum + " " + i);
                if(dis > sum){
                    dis = sum;
                    ans = i;
                }else if(dis == sum){
                    ans = Math.min(ans,i);
                }
            }
        }
        return ans;
    }
}