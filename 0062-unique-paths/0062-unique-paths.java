class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1 && n==1) return 1;

        int[][] dp = new int[m][n];
        // for(int[] row:dp) Arrays.fill(row,0);
        // dp[0][0] = 1;
        dp[m-1][n-1]=1;
        int up = 0, left = 0;      
        for(int i = m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1) dp[i][j] = 1;
                else
                {
                    if(i<m-1) up = dp[i+1][j];
                    else up = 0;

                    if(j<n-1) left  = dp[i][j+1];
                    else left = 0;

                    dp[i][j] = left+up;
                }
            }
        }
        return dp[0][0];
    }
}