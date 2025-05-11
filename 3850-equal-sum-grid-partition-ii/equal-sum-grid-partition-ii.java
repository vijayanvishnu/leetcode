class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long hSum[] = new long[grid[0].length + 1];
        //System.out.println("-----");
        for (int i = 0; i < grid[0].length; i++) {
            long sum = 0;
            for (int j = 0; j < grid.length; j++) {
                sum = grid[j][i] + sum;
            }
            hSum[i + 1] = hSum[i] + sum;
        }
        // System.out.println(Arrays.toString(hSum));
        long hSums = 0L;
        Set<Long> set = new HashSet<>();
        for (int i = grid[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                hSums = grid[j][i] + hSums;
                set.add((long) grid[j][i]);
            }
            if (hSums == hSum[i]) {
                return true;
            }
            // System.out.println(hSums + " " + hSum[i]);
            boolean sRow = grid.length == 1;
            boolean sCol = i == grid[0].length - 1;
            if (hSums > hSum[i] && set.contains(hSums - hSum[i])) {
                // System.out.println("in");
                if (sCol && (grid[0][i] == hSums - hSum[i] || grid[grid.length - 1][i] == hSums - hSum[i])) {
                    return true;
                }
                if (!sRow && !sCol) {
                    return true;
                }
                long req = hSums - hSum[i];
                if(sRow && (grid[0][i] == req|| grid[0][grid[0].length - 1] == req)){
                    return true;
                }
            }
        }
        // System.out.println(hSums);
        set = new HashSet<>();
        long hSumTotal = hSum[grid[0].length];
        hSums = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                hSums = grid[j][i] + hSums;
                set.add((long) grid[j][i]);
            }
            long remSum = hSumTotal - hSums;
            boolean sRow = grid.length == 1;
            boolean sCol = i == 0;
            //System.out.println(hSums + " remSum : " + remSum + " " + hSumTotal);
            if (hSums > remSum && set.contains(hSums - remSum)) {
                // System.out.println("in");
                if (sCol && (grid[0][i] == hSums - remSum || grid[grid.length - 1][i] == hSums - remSum)) {
                    return true;
                }
                if (!sCol && !sRow) {
                    return true;
                }
                 long req = hSums - remSum;
                if(sRow && (grid[0][i] == req|| grid[0][0] == req)){
                    return true;
                }
            }
        }
        // System.out.println("helo");
        long vSum[] = new long[grid.length + 1];
        for (int i = 0; i < grid.length; i++) {
            long sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum = grid[i][j] + sum;
            }
            vSum[i + 1] = vSum[i] + sum;
        }
        long vSums = 0L;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                vSums = grid[i][j] + vSums;
                set.add((long) grid[i][j]);
            }
            if (vSums == vSum[i]) {
                return true;
            }
            boolean sRow = i == grid.length - 1;
            boolean sCol = grid[0].length == 1;
            //System.out.println(vSums + " " + vSum[i]);
            if (vSums > vSum[i] && set.contains(vSums - vSum[i])) {
                //  System.out.println("in");
                if (sRow && (grid[i][0] == vSums - vSum[i] || grid[i][grid[0].length - 1] == vSums - vSum[i])) {
                    return true;
                }
                if (!sCol && !sRow) {
                    // System.out.println(i + " " + grid.length + " " + vSums + " " + vSum[i]);
                    return true;
                }
                 if (sCol && (grid[i][0] == vSums - vSum[i] || grid[grid.length - 1][0] == vSums - vSum [i])) {
                    return true;
                }
            }
        }
        vSums = 0;
        set = new HashSet<>();
        long vSumTotal = vSum[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                vSums = grid[i][j] + vSums;
                set.add((long) grid[i][j]);
            }
            long remSum = vSumTotal - vSums;
            // System.out.println(vSums + " " + remSum);
            boolean sRow = i == 0;
            boolean sCol = grid[0].length == 1;
            long req = vSums - remSum;
            if (vSums > remSum && set.contains(vSums - remSum)) {
                // System.out.println("in");
                if (sRow && (grid[i][0] == vSums - remSum || grid[i][grid[0].length - 1] == vSums - remSum)) {

                    return true;
                }
                if (!sRow && !sCol) {
                    return true;
                }
                if (sCol && (grid[i][0] == req || grid[0][0] == req)) {
                    return true;
                }
            }
        }
        return false;
    }
}