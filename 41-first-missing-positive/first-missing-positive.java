class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Long> set = new HashSet<>();
        long max = 1;
        for(int i : nums){
            max = Math.max(i,max);
            set.add((long)i);
        }
        long i = 1;
        while(i <= max + 1){
            if(!set.contains(i)){
                return (int) i;
            }
            i++;
        }
        return -1;
    }
}