class Solution {
    private boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        if(n < 4){
            return true;
        }
        int i = 2;
        while(i * i <= n){
            if(n % i == 0) return false;
            i++;
        }
        return true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            if(isPrime(nums[l])) break;
            l++;
        }
        while(l <= r){
            if(isPrime(nums[r])) break;
            r--;
        }
        return r - l;
    }
}