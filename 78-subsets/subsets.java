class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        int total = (int) Math.pow(2,nums.length);
        for(int i=0 ; i<total ; i++){
            LinkedList<Integer> inner = new LinkedList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))>0){
                    inner.add(nums[j]);
                }
            }
            list.add(inner);
        }
        return list;
    }
}