class Solution {
    private boolean dfsHelper(int start,ArrayList<Integer> graph[],Set<Integer> completed,boolean visited[]){
        if(completed.contains(start)){
            return true;
        }
        if(visited[start]){
            return false;
        }
        visited[start] = true;
        boolean ans = true;
        for(int i : graph[start]){
            ans = ans && dfsHelper(i,graph,completed,visited);
        }
        if(ans){
            completed.add(start);
        }
        return ans;
    }
    public boolean canFinish(int numCourses, int[][] nums) {
        boolean visited[] = new boolean[numCourses];
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < nums.length ; i++){
            graph[nums[i][1]].add(nums[i][0]);
        }
        int cmp = 0;
        Set<Integer> completed = new HashSet<>();
        boolean ans = true;
        for(int i = 0 ; i < numCourses ; i++){
            ans = ans && dfsHelper(i,graph,completed,new boolean[numCourses]);
        }
        return ans && completed.size() == numCourses;
    }
}