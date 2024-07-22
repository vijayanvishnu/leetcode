class Solution {
    public int minChanges(int[] nums, int k) {
        int hash[] = new int[k + 1];
        int chash[] = new int[k + 1];
        int itrMax = nums.length / 2;
        int n = nums.length;
        for(int i = 0 ; i < itrMax ; i++){
            int idx = n - i - 1;
            chash[Math.abs(nums[idx] - nums[i])]+=2;
            int max = Math.max(Math.max(nums[i],nums[idx]),k - Math.min(nums[i],nums[idx]));
            hash[max]+=2;
        }
        System.out.println(Arrays.toString(hash));
        int sum = 0;
        int ans = n;
        for(int i = k ; i > -1 ; i--){
            sum = sum + hash[i] - chash[i];
            ans = Math.min(ans,sum / 2 + n - sum - chash[i]);
            // System.out.println(sum + " " + chash[i]);
            sum = sum + chash[i];
            // System.out.println(k + " " + (sum / 2 + n - sum - chash[i]));
        }
        return ans;
    }
}