class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < apple.length ; i++){
            sum = sum + apple[i];
        }
        int cap = 0;
        for(int i = capacity.length - 1; i > - 1; i--){
            if(sum > cap){
                ans++;
                cap += capacity[i];
            }else{
                break;
            }
        }
        return ans;
    }
}