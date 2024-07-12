class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;

        int[][] dp = new int[m][n];
        // for(int[] row:dp) Arrays.fill(row,0);
        dp[0][0] = 1;
        int up = 0, left = 0;      
        for(int i = 0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[i][j] = 1;
                else
                {
                    if(i>0) up = dp[i-1][j];
                    else up = 0;

                    if(j>0) left  = dp[i][j-1];
                    else left = 0;

                    dp[i][j] = left+up;
                }
            }
        }
        return dp[m-1][n-1];
    }
}