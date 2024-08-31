class Solution {
    long fact[] = new long[11];
    Set<String> visited;
    private long helper(int nums[],int l,int r,int k){
        long ans = 0;
        if(l > r){
            long q = 0;
            for(int i = 0 ; i < nums.length ; i++){
                q = q * 10 + nums[i];
            }
            if(q % k == 0){
                int count = nums.length;
                int zeros = 0;
                int hash[] = new int[10];
                for(int i = 0 ; i < nums.length ;  i++){
                    if(nums[i] == 0){
                        zeros++;
                    }
                    hash[nums[i]]++;
                }
                if(visited.contains(Arrays.toString(hash))){
                    return 0l;
                }
                ans = count - zeros;
                visited.add(Arrays.toString(hash));
                ans = ans * fact[count - 1];
                for(int i = 0 ; i < 10 ; i++){
                    ans = ans / fact[hash[i]];
                }
                return ans;
            }else{
                return 0l;
            }
        }else if(l == r){
            for(int i = 0 ; i < 10 ; i++){
                nums[l] = nums[r] = i;
                ans = ans + helper(nums , l + 1 , r , k);
            }
        }else{
            int i = (l != 0 ? 0 : 1);
            for(; i < 10 ; i++){
                nums[l] = nums[r] = i;
                ans = ans + helper(nums,l + 1 ,r - 1 , k);
            }
        }
        return ans;
    }
    public long countGoodIntegers(int n, int k) {
        fact[0] = 1;
        for(int i = 1 ; i < 11 ; i++){
            fact[i] = fact[i - 1] * i;
        }
        visited = new HashSet<>();
        return helper(new int[n],0,n - 1,k);
    }
}