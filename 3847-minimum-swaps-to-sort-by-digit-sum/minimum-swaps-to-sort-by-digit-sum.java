class Solution {
    private int sumOfDigits(int num) {
        int ans = 0;
        int n = num;
        while (num > 0) {
            ans = ans + num % 10;
            num /= 10;
        }
        // System.out.println(ans + " " + n);
        return ans;
    }

    public int minSwaps(int[] nums) {
        Integer copy[] = new Integer[nums.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = nums[i];
        }
        Map<Integer, Integer> hashTable = new HashMap<>();
        int swaps = 0;
        Arrays.sort(copy, (a, b) -> {
            int as = sumOfDigits(a);
            int bs = sumOfDigits(b);
            if (as != bs) {
                return as > bs ? 1 : -1;
            } else {
                return a > b ? 1 : -1;
            }
        });
       //  System.out.println(Arrays.toString(copy));
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(copy[i], i);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int idx = hashTable.get(nums[i]);
            while (idx != i) {
                int t = nums[i];
                nums[i] = nums[idx];
                nums[idx] = t;
                ans++;
                idx = hashTable.get(nums[i]);
            }
        }
        return ans;
    }
}