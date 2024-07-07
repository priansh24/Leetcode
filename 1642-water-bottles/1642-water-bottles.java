class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles>=numExchange)
        {
            int consumed = (numBottles/numExchange);
            ans += consumed;
            int bottlesRemaining = numBottles%numExchange;
            numBottles = consumed + bottlesRemaining;
        }
        return ans;
    }
}