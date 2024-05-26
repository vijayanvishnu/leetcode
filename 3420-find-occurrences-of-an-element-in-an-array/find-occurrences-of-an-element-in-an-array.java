class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> ref = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(x == nums[i]){
                ref.add(i);
            }
        }
        int in = 0;
        int res[] = new int[queries.length];
        for(int i : queries){
            if(i > ref.size()){
                res[in++] = -1;
            }else{
                res[in++] = ref.get(i - 1);
            }
        }
        return res;
    }
}