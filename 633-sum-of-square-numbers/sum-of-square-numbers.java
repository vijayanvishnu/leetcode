class Solution {
    public boolean judgeSquareSum(int c) {
        if(c == 0) return true;
        for(long i = 1 ; i * i <= c ; i++){
            long f = c - i * i;
            if(f>=0){
                long sqrt = (long) Math.ceil(Math.sqrt(f));
                long longSqrt = (long) Math.sqrt(f);
                if(sqrt == longSqrt){
                    return true;
                }
            }
            long s = c - (c/i) * (c/i);
            if(s>=0){
                long sqrt = (long) Math.ceil(Math.sqrt(s));
                long longSqrt = (long) Math.sqrt(s);
                if(sqrt == longSqrt){
                    return true;
                }
            }
        }
        return false;
    }
}