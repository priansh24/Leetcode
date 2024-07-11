class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String rev = sb.toString();
        return longestCommonSubsequence(s,rev);
    }

    private int longestCommonSubsequence(String s, String rev)
    {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i = n-1;i>=0;i--)
        {
            for(int j = n-1;j>=0;j--)
            {
                int ans = 0;
                if(s.charAt(i)==rev.charAt(j))
                {
                    ans = 1 + dp[i+1][j+1];
                }
                else
                {
                    ans = Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}