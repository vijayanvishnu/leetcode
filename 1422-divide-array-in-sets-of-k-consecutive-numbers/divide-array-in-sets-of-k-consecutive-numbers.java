class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        Arrays.sort(nums);
        Map<Integer,Integer> first = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int key = nums[i];
            if(!first.containsKey(key)){
                first.put(key, i);
            }
        }
        int min = 0;
        int sets = 0;
        while(first.size() > 0){
            // System.out.println(first);
            if(min == Integer.MAX_VALUE){
                min = sets * k;
            }
            int start = nums[min];
            int end = start + k;
            min = Integer.MAX_VALUE;
            while(start < end){
                if(first.containsKey(start)){
                    int curr = first.get(start);
                    if(nums.length - 1 > curr && nums[curr + 1] == start){
                        first.put(start,curr + 1);
                        min = Math.min(min , curr + 1);
                    }else{
                        first.remove(start);
                    }
                }else{
                    return false;
                }
                start++;
            }
            sets++;
        }
        return true;
    }
}