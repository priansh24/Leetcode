class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        helper(grid,dp,m-1,n-1);
        return dp[m-1][n-1];
    }

    private int helper(int[][] grid, int[][] dp,int row, int col)
    {
        if(col==0 && row==0) return grid[row][col];
        if(row<0 || col<0) return Integer.MAX_VALUE;
        if(dp[row][col]!=0) return dp[row][col]; 
        dp[row][col] = grid[row][col] + Math.min(helper(grid,dp,row-1,col), helper(grid,dp,row,col-1)); 
        return dp[row][col];
    }
}