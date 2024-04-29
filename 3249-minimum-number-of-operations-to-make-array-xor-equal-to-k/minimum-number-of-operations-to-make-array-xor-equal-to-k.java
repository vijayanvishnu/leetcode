class Solution {
    public int minOperations(int[] nums, int k) {
        int bits[] = new int[32];
        for(int i=0;i<nums.length;i++){
            int kk = 0;
            while(nums[i]>0){
                bits[kk] = bits[kk] + nums[i] % 2;
                nums[i] >>= 1;
                kk++;
            }
        }
        int req[] = new int[32];
        int idx = 0;
        while(k>0){
                bits[idx] = bits[idx] + k % 2;
                k >>= 1;
                idx++;
        }
        int res = 0;
        for(int i=0;i<32;i++){
            if(bits[i]%2==1){
                if(req[i] != 1) res++;
            }else{
                if(req[i] != 0) res++;
            }
        }
        return res;
    }
}