class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxProfit = 0;
        Pair pair[] = new Pair[difficulty.length];
        for(int i = 0;i<difficulty.length;i++)
        {
            pair[i] = new Pair(difficulty[i],profit[i]);
        }
        Arrays.sort(pair,(a,b) -> a.difficultyLevel - b.difficultyLevel);
        Arrays.sort(worker);
        int i = 0;
        int maxPaySoFar = 0;
        for(int ability:worker)
        {
            while(i<pair.length && ability>=pair[i].difficultyLevel)
            {
                if(maxPaySoFar<pair[i].profit) maxPaySoFar = pair[i].profit;
                i++;
            }
            maxProfit += maxPaySoFar;
        }
        return maxProfit;
    }
}

class Pair {
    int profit;
    int difficultyLevel;
    Pair(int difficultyLevel, int profit)
    {
        this.difficultyLevel = difficultyLevel;
        this.profit = profit;
    }
}