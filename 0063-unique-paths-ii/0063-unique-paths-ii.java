class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int right = 0;
        int down = 0;
        if(m==0 && n==0)
        {
            if(grid[0][0]==0) return 1;
            else return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    dp[i][j] = 0;
                    continue;
                }
                if(i==0 && j==0) dp[i][j] = 1;
                else
                {
                    if(i>0 && grid[i-1][j]!=1) down = dp[i-1][j];
                    else down = 0;

                    if(j>0 && grid[i][j-1]!=1) right = dp[i][j-1];
                    else right = 0;

                    dp[i][j] = right+down;
                }
            }
        }
        return dp[m-1][n-1];
    }
}