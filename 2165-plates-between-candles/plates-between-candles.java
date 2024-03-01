class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int plates[] = new int[s.length() + 1];
        int leftCandle[] = new int[s.length()];
        leftCandle[0] = -1;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '*'){
                plates[i + 1] = 1;
                if(i != 0){
                    leftCandle[i] = leftCandle[i-1];
                }
            }else{
                leftCandle[i] = i;
            }
            plates[i + 1] = plates[i] + plates[i + 1];
        }
        int rightCandle[] = new int[s.length()];
        rightCandle[rightCandle.length - 1] = -1;
        for(int i = rightCandle.length - 1 ; i > -1 ; i--){
            if(s.charAt(i) == '|'){
                rightCandle[i] = i;
            }else{
                if(i != rightCandle.length - 1){
                    rightCandle[i] = rightCandle[i + 1];
                }
            }
        }
        int ans[] = new int[queries.length];
        for(int i = 0; i < queries.length ; i++){
            int right = rightCandle[queries[i][0]];
            int left = leftCandle[queries[i][1]];
            if(left == -1 || right == -1 || right > left){
                ans[i]  = 0;
            }else{
                ans[i] = plates[left] - plates[right + 1];
            }
        }
        return ans;
    }
}