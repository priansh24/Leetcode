class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int dp[][] = new int[r+1][c+1];
        int max = 0;
        for(int i = r-1; i>=0; i--)
        {
            for(int j = c-1; j>=0; j--)
            {
                int down = dp[i+1][j];
                int right = dp[i][j+1];
                int diagonal = dp[i+1][j+1];

                if(matrix[i][j]=='1')
                {
                    dp[i][j] = 1+Math.min(diagonal,Math.min(right,down));
                    max = Math.max(max,dp[i][j]);
                }
                else dp[i][j] = 0; 
            }
        }
        return max*max;
    }
}