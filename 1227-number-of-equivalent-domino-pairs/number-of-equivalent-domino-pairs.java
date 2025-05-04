class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int hash[][] = new int[10][10];
        int ans = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int x = dominoes[i][0];
            int y = dominoes[i][1];
            ans = hash[x][y] + ans;
            if (x != y) {
                ans = ans + hash[y][x];
            }
            hash[x][y]++;
        }
        return ans;
    }
}