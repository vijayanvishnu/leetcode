class Solution {
    public int countTrapezoids(int[][] points) {
        long ans = 0;
        long mod = 1_000_000_007;
        Set<Integer> yaxis = new TreeSet<>();
        Map<Integer,Integer> count = new HashMap<>();
        for(int i[] : points){
            int x = i[0];
            int y = i[1];
            count.putIfAbsent(y,0);
            count.put(y,count.get(y) + 1);
            yaxis.add(y);
        }
        long countAns = 0L;
        for(int i : yaxis){
            long currPair = count.get(i) * 1L;
            currPair -= 1;
            currPair = currPair * (currPair + 1) / 2;
            ans = ans + (currPair * countAns);
            ans = ans % mod;
            countAns += currPair;
        }
        return (int) ans;
    }
}