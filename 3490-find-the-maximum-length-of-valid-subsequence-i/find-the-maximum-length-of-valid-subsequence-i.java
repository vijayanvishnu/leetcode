class Solution {
    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        int mixed1 = 0;
        int mixed2 = 0;
        boolean flag1 = true;
        // find odd , even
        boolean flag2 = true;
        // find even , odd
        for(int i : nums){
            boolean isOdd = (i & 1)  == 1;
            if(isOdd) odd++;
            else even++;
            if(isOdd){
                if(flag1){
                    flag1 = !flag1;
                    mixed1++;
                }
                if(!flag2){
                    flag2 = !flag2;
                    mixed2++;
                }
            }else{
                if(flag2){
                    flag2 = !flag2;
                    mixed2++;
                }
                if(!flag1){
                    flag1 = !flag1;
                    mixed1++;
                }
            }
        }
        return Math.max(Math.max(even,odd),Math.max(mixed1,mixed2));
    }
}