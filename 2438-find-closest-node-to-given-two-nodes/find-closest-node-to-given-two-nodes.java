class Solution {
    public int closestMeetingNode(int[] edges, int src, int dst) {
        Map<Integer,Integer> srcPath = new HashMap<>();
        int dis = 0;
        int curr = src;
        while(curr != -1 && !srcPath.containsKey(curr)){
            srcPath.put(curr,dis);
            curr = edges[curr];
            dis++;
        }
        int ans = -1;
        curr = dst;
        dis = 0;
        int ansDis = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        while(curr != -1 && !visited.contains(curr)){
            if(srcPath.containsKey(curr)){
                int maxDis = Math.max(srcPath.get(curr) , dis);
                // System.out.println(sum + " " + i);
                if(ansDis > maxDis){
                    ansDis = maxDis;
                    ans = curr;
                }else if(ansDis == maxDis){
                    ans = Math.min(ans,curr);
                }
            }
            visited.add(curr);
            curr = edges[curr];
            dis++; 
        }
        return ans;
    }
}