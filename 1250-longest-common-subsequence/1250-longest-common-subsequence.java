class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0;i<n1;i++) Arrays.fill(dp[i],-1);
        return helper(text1,text2,n1,n2,dp,0,0);
    }

    private int helper(String a, String b, int n1, int n2,int[][]dp, int i, int j)
    {
        int ans = 0;
        if(i==n1 || j==n2) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(a.charAt(i)==b.charAt(j))
        {
            ans = 1+helper(a,b,n1,n2,dp,i+1,j+1);
        }
        else
        {
            ans = Math.max(helper(a,b,n1,n2,dp,i+1,j),helper(a,b,n1,n2,dp,i,j+1)); 
        }
        // dp[i][j] = ans;
        return dp[i][j]=ans;
    }
}