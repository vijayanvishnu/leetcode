class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            int ref = s.charAt(left);
            boolean found = false;
            int c = 0;
            while(left < right && ref == s.charAt(left)){
                c++;
                left++;
            }
            while(right > -1 && ref == s.charAt(right)){
                found = true;
                right--;
            }
            if(!found){
                left -= c;
                break;
            }
        }
        if(right < left){
            return 0;
        }
        return right - left + 1;
    }
}