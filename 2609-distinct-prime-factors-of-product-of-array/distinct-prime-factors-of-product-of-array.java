class Solution {
    static boolean prime[] = new boolean[1_00_1];
    static {
        prime[0] = prime[1] = true;
        for(int i = 2 ; i * i < prime.length ; i++){
            if(!prime[i]){
                for(int j = i * i ; j < prime.length ; j = j + i){
                    prime[j] = true;
                }
            }
        }
    }
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactors = new HashSet<>();
        for(int i : nums){
            int j = 1;
            while(j * j <= i){
                if(i%j == 0){
                    if(!prime[j]){
                        primeFactors.add(j);
                    }
                    if(!prime[i/j]){
                        primeFactors.add(i/j);
                    }
                }
                j++;
            }
        }
        return primeFactors.size();
    }
}