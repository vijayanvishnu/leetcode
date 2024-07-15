class Solution {
    public int edgeScore(int[] edges) {
        long edgeSum[] = new long[edges.length];
        for(int i = 0 ; i < edges.length ; i++){
            int in = edges[i];
            int out = i;
            edgeSum[in] += out;
        }
        long max = 0;
        int idx = 0;
        for(int i = 0 ; i < edges.length ; i++){
            if(edgeSum[i] > max){
                max = edgeSum[i];
                idx = i;
            }
        }
        return idx;
    }
}