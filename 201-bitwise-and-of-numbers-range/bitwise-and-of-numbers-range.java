class Solution {
    public int rangeBitwiseAnd(int left, int right) {
      int res = 0 ;
      while(left<right){
        res++;
        left >>= 1;
        right >>= 1;
      }
      return left << res;
    }
}