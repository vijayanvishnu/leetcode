class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        LinkedList<Character> stack = new LinkedList<>();
        stack.addLast(num.charAt(0));
        for(int i = 1 ; i < num.length() ; i++){
            while(k > 0 && stack.size() > 0 && stack.peekLast() > num.charAt(i)){
                stack.pollLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }
        while(k>0){
            stack.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size() > 0 && stack.peekFirst() == '0'){
            stack.pollFirst();
        }
        while(stack.size()>0){
            sb.append(stack.pollFirst());
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }
}