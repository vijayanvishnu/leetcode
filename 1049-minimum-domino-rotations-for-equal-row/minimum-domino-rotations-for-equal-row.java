class Solution {
    public int maxSwaps(int top[], int bottom[], int x) {
        int swaps = 0;
        for (int i = 0; i < top.length; i++) {
            if (top[i] != x) {
                if (bottom[i] != x) {
                    return Integer.MAX_VALUE;
                }
                swaps++;
            }
        }
        return swaps;
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            ans = Math.min(maxSwaps(tops, bottoms, i), ans);
        }
        for (int i = 1; i < 7; i++) {
            ans = Math.min(maxSwaps(bottoms, tops, i), ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}