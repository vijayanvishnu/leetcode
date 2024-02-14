class Solution {
    public int maxProfit(int[] price) {
        int profit[] = new int[price.length + 1];
        int min = price[price.length - 1];
        int max = price[price.length - 1];
        for(int i = price.length - 1 ; i >= 0 ; i--){
            if(min > price[i]){
                min = price[i];
            }
            if(max < price[i]){
                max = price[i];
                min = price[i];
            }
            profit[i]  = max - min;
            profit[i] = Math.max(profit[i + 1] , profit[i]);
        }
        min = price[0];
        max = price[0];
        int prefProfit = 0;
        int ans = 0;
        for(int i = 0 ; i < price.length ; i++){
            if(min > price[i]){
                min = price[i];
                max = price[i];
            }
            if(max < price[i]){
                max = price[i];
            }
            prefProfit = Math.max(prefProfit , max - min);
            ans = Math.max(prefProfit + profit[ i + 1],ans);
        }
        return ans;
    }
}