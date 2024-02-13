class Solution {
    public long smallestNumber(long num) {
        long myNum = (num < 0 ? - 1 : 1) * num;
        boolean negative = myNum != num;
        long t = myNum;
        int size = 0;
        while(t>0){
            size++;
            t/=10;
        }
        Integer nums[] = new Integer[size];
        int idx = 0;
        while(myNum > 0){
            nums[idx] = (int)(myNum % 10);
            myNum /= 10;
            idx++;
        }
        if(negative){
            Arrays.sort(nums,(x,y) -> Integer.compare(y, x));
            long ans = 0;
            idx = 0;
            while(idx < nums.length){
                ans = ans * 10 + nums[idx];
                idx++;
            }
            return -1 * ans;
        }else{
            Arrays.sort(nums);
            idx = 0;
            int z = 0;
            long ans = 0;
            while(idx < nums.length  && nums[idx] == 0){
                z++;
                idx++;
            }
            if(idx == nums.length){
                return ans;
            }
            ans = nums[idx];
            idx++;
            while(z-->0){
                ans = ans * 10;
            }
            while(idx < nums.length){
                ans = ans * 10 + nums[idx];
                idx++;
            }
            return ans;
        }
    }
}