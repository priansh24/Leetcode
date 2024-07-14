class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();

        // Space  ->  O(n)
        // int[] dp = new int[height];
        // int ind = 0;
        // for(int i:triangle.get(height-1))
        //     dp[ind++] = i;
        
        // for(int level = height-2;level>=0;level--)
        // {
        //     for(ind=0;ind<=level;ind++)
        //     {
        //         int currVal = triangle.get(level).get(ind);
        //         int sum = Math.min(dp[ind],dp[ind+1]);
        //         dp[ind] = currVal+sum;
        //     }
        // }
        // return dp[0];


        // Space  ->  O(n2)
    /*
        int[][] dp = new int[height+1][height+1];

        for(int level = height-1;level>=0;level--)
        {
            for(int ind = 0;ind<=level;ind++)
            {
                int currVal = triangle.get(level).get(ind);
                int sum = Math.min(dp[level+1][ind],dp[level+1][ind+1]);
                dp[level][ind] = currVal+sum;
            }
        }
        return dp[0][0];
    */

    // Space  ->  O(1)

        for(int level = height-2;level>=0;level--)
        {
            for(int ind = 0;ind<triangle.get(level).size();ind++)
            {
                int currVal = triangle.get(level).get(ind);
                int sum = Math.min(triangle.get(level+1).get(ind),triangle.get(level+1).get(ind+1));
                triangle.get(level).set(ind,currVal+sum);
            }
        }
        return triangle.get(0).get(0);
    }
}