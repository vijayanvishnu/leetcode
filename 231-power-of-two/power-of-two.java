class Solution {
    public boolean isPowerOfTwo(int n) {
        long ln = n ;
        if(n == 0) return false;
        if(n == 1) return true;
        return (ln & (ln - 1)) == 0;
    }
}