class Solution {
    int uFds[];
    private int find(int idx){
        if(idx == uFds[idx]){
            return idx;
        }
        return uFds[idx] = find(uFds[idx]);
    }
    private void union(int idxA,int idxB){
        int prnt_a = find(idxA);
        int prnt_b = find(idxB);
        uFds[prnt_a] = prnt_b;
    }
    public boolean canTraverseAllPairs(int[] nums) {
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
        }
        // System.out.println(max);
        uFds = new int[1_000_01];
        for(int i = 0 ; i < uFds.length ; i++){
            uFds[i] = i;
        }
        Map<Integer,List<Integer>> divisors = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            for(int j = 2 ; j * j  <= nums[i] ; j++){
                if(nums[i] % j == 0){
                    divisors.putIfAbsent(nums[i]/j,new ArrayList<>());
                    divisors.get(nums[i]/j).add(i);
                    divisors.putIfAbsent(j,new ArrayList<>());
                    divisors.get(j).add(i);
                    divisors.putIfAbsent(j,new ArrayList<>());
                    divisors.get(j).add(i);
                }
            }
            if(nums[i] != 1){
                divisors.putIfAbsent(nums[i],new ArrayList<>());
                divisors.get(nums[i]).add(i);
            }
        }
        for(List<Integer> i : divisors.values()){
            int prnt = i.get(0);
            for(int j = 1 ; j < i.size() ; j++){
                union(prnt , i.get(j));
            }
            // System.out.println(Arrays.toString(uFds));
        }
        int prnt = find(0);
        for(int i = 0 ; i < nums.length ; i++){
            if(prnt != find(i)) return false;
        }
        return true;
    }
}