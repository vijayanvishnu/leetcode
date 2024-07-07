class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        int avialable = numBottles;
        while(avialable/numExchange!=0){
            drink+=avialable/numExchange;
            avialable=avialable%numExchange+avialable/numExchange;
        }
        return drink;
    }
}