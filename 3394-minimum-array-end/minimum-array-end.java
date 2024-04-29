class Solution {
    public long minEnd(int n, int x) {
        long ln = n - 1;
        long res = 0;
        int shift = 0;
        while(ln > 0 || x > 0){
            long curr = 0;
            if((x&1) == 0){
                curr = (ln&1) << shift;
                ln >>= 1;
            }else{
                curr = (x&1) << shift;
            }
            res = res | curr;
            x >>= 1;
            shift++;
        }
        return res;
    }
}