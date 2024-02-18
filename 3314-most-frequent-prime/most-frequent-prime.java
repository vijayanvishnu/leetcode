class Solution {
    int dir[][] = new int[][] { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

    public boolean isPrime(int num) {
        int k = (int) Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void check(int mat[][], int m, int n, int l, int j, Map<Integer, Integer> map) {
        for (int i = 0; i < dir.length; i++) {
            int x = l;
            int y = j;
            int val = 0;
            boolean flag = true;
            while (x < m && x >= 0 && y < n && y >= 0) {
                val = val * 10 + mat[x][y];
                x += dir[i][0];
                y += dir[i][1];
                if (val > 10 && isPrime(val)) {
                    map.put(val, map.getOrDefault(val, 0) + 1);
                }
            }
        }
    }

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                check(mat, m, n, i, j, map);
            }
        }
        int res = -1;
        int f = 0;
        System.out.println(map);
        for (int i : map.keySet()) {
            int fre = map.get(i);
            if (fre == f) {
                if (res < i)
                    res = i;
            }
            if (fre > f) {
                res = i;
                f = fre;
            }
        }
        return res;
    }
}