class Solution {
    public int preimageSizeFZF(int k) {
        long left = 0;
        long right = (long) Math.pow(10,10);
        while(left <= right){
            long mid = left + (( right - left ) >> 1);
            long val = mid;
            long c= 0;
            while(val > 0){
                val = val / 5;
                c = c + val;
            }
            if(k == c){
                return 5;
            }else if(k > c){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}