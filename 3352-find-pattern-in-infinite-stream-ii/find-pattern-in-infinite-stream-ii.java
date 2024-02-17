/**
 * Definition for an infinite stream.
 * class InfiniteStream {
 *     public InfiniteStream(int[] bits);
 *     public int next();
 * }
 */
class Solution {
    private int[] getLPS(int nums[]){
        int i = 1;
        int lps[] = new int[nums.length];
        lps[0] = 0;
        int j = 0;
        while(i < nums.length){
            if(nums[i] == nums[j]){
                j++;
                lps[i] = j;
                i++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int lps[] = getLPS(pattern);
        int i = 0;
        int j = 0;
        int size = 1_00_001 + pattern.length;
        int previ = -1;
        int v = 0;
        while(i < size){
            if(i != previ){
                v = infiniteStream.next();
                previ = i;
            }
            if(v == pattern[j]){
                j++;
                i++;
            }else{
                if(j != 0)
                j = lps[j - 1];
                else{
                    i++;
                }
            }
            if(j == pattern.length){
                return i - pattern.length;
            }
        }
        return 0;
    }
}