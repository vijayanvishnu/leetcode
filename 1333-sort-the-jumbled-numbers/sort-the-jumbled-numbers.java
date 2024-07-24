class Solution {
    public int[] sortJumbled(int[] mapping, int[] given) {
        int n = given.length;
        int nums[][] = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            nums[i][0] = given[i];
            String numsStr = Integer.toString(given[i]);
            for(int j = 0 ; j < numsStr.length() ; j++){
                nums[i][1] = nums[i][1] * 10 + mapping[numsStr.charAt(j) - '0'];
            }
        }
        Arrays.sort(nums,(a,b)->a[1]-b[1]);
        for(int i = 0 ; i < n ; i++){
            given[i] = nums[i][0];
        }
        return given;
    }
}