class Solution {
    public String firstPalindrome(String[] words) {
        for(int i = 0 ; i < words.length ; i++){
            char str[] = words[i].toCharArray();
            int left = 0;
            int right = str.length - 1;
            while(left < right){
                if(str[left] != str[right]){
                    break;
                }
                left++;
                right--;
            }
            if(left >= right){
                return words[i];
            }
        }
        return "";
    }
}