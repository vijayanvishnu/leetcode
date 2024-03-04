class Solution {
    public int countSubmatrices(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int tem[][] = new int[n][m];
        int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += mat[i][j];
                tem[i][j] = sum;
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += tem[j][i];
                tem[j][i] = sum;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tem[i][j] <= k) cnt++;
            }
        }
        return cnt;
    }
}