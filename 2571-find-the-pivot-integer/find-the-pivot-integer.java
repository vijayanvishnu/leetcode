class Solution {
    public int pivotInteger(int n) {
        int left = 0;
        int right = n;
        int sum = n * ( n + 1 ) / 2;
        while(left <= right){
            int mid = (left + right) / 2;
            int sMid = mid * ( mid + 1 ) / 2;
            if(sMid == sum - sMid + mid){
                return mid;
            }else if(sMid < sum - sMid + mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}