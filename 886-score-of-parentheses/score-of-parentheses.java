class Solution {
    private int helper(int nums[],int l,int r){
        if(l == r - 1){
            return 1;
        }
        int ans = 0;
        int i = l + 1;
        while(i < r){
            ans = ans + 2 * helper(nums,i,nums[i]);
            i = nums[i] + 1;
        }
        return ans;
    }
    public int scoreOfParentheses(String s) {
        s = "(" + s + ")";
        Stack<Integer> stack = new Stack<>();
        int nums[] = new int[s.length()];
        Arrays.fill(nums,-1);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                nums[stack.pop()] = i;
            }
        }
        int ans = helper(nums,0,nums.length - 1);
        return ans / 2;
    }
}