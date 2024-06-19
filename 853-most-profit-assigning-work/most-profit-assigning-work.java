class Solution {
    private int binarySearch(int nums[][] , int key){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2 ;
            if(nums[mid][0] <= key){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int nums[][] = new int[profit.length][2];
        int n = profit.length;
        for(int i = 0 ; i < n ; i++){
            nums[i][0] = difficulty[i];
            nums[i][1] = profit[i];
        }
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));
        int max[] = new int[n + 1];
        for(int i = 0; i < n ; i++){
            max[i + 1] = Math.max(max[i] , nums[i][1]);
        }
        int ans = 0;
        for(int i = 0 ; i < worker.length ; i++){
            int bs = binarySearch(nums , worker[i]);
            ans = ans + max[bs];
        }
        return ans;
    }
}