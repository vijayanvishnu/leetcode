class Solution {
    Map<String,Integer> dp = null;
    private int backtrack(char string[], char array[], int stringIdx, int arrayIdx){
        if(arrayIdx == 0 || stringIdx == 0){
            return stringIdx == 0 ? arrayIdx : stringIdx;
        }
        String path = stringIdx + "->" + arrayIdx;
        if(array[arrayIdx-1] == string[stringIdx-1]){
            return backtrack(string, array, stringIdx-1, arrayIdx-1);
        }
        if(dp.containsKey(path)){
            return dp.get(path);
        }
        int insert = backtrack(string, array, stringIdx, arrayIdx-1);
        int delete = backtrack(string, array, stringIdx-1, arrayIdx);
        int replace = backtrack(string, array, stringIdx-1, arrayIdx-1);
        int res = Math.min(Math.min(insert, delete), replace)+1;
        dp.put(path, res);
        return res;
    }
    public int minDistance(String word1, String word2) {
        dp = new HashMap<>();
        return backtrack(word1.toCharArray(), word2.toCharArray(), word1.length(), word2.length());
    }
}