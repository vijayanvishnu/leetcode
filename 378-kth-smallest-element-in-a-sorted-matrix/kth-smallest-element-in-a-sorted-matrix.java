class Solution {
    private int helper(int nums[][],int val){
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < nums.length && j > -1){
            if(nums[i][j] <= val){
                ans = ans + j + 1;
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            int count = helper(matrix,mid);
            if(count >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}