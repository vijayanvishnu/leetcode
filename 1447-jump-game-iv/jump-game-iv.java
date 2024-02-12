class Solution {
    public int minJumps(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i] ,new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        q.add(0);
        int res = 0;
        Set<Integer> resMap = new HashSet<>();
        Set<Integer> resNum = new HashSet<>();
        resMap.add(0);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int poll = q.poll();
                if(poll == nums.length - 1){
                    return res;
                }
                if(!resNum.contains(nums[poll])){
                    List<Integer> list = map.get(nums[poll]);
                    for(int i : list){
                        if(!resMap.contains(i)){
                            resMap.add(i);
                            q.add(i);
                        }
                    }
                    resNum.add(nums[poll]);
                }
                if(poll != 0 && !resMap.contains(poll - 1)){
                    q.add(poll - 1);
                    resMap.add(poll - 1);
                }
                if(!resMap.contains(poll + 1) && poll + 1 != nums.length){
                    q.add(poll + 1);
                    resMap.add(poll + 1);
                }
            }
            res++;
        }
        return nums.length - 1;
    }
}