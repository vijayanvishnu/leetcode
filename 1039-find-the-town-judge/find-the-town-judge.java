class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0){
            if(n == 1) return n;
            else return -1;
        }
        int[] map = new int[n+1];
        for(int arr[] : trust){
            map[arr[1]] = map[arr[1]] + 1;
            map[arr[0]] = Integer.MIN_VALUE;
        }
        for(int i=1;i<=n;i++){
            if(map[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}