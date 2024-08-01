class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        Integer[][] dp = new Integer[m][n];

        return helper(word1,word2,dp,m-1,n-1);
    }

    private int helper(String word1, String word2, Integer[][] dp,int i, int j)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=null) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j] = helper(word1,word2,dp,i-1,j-1);
        else
        {
            return dp[i][j] =  1 + Math.min(helper(word1,word2,dp,i-1,j-1),Math.min(helper(word1,word2,dp,i-1,j),helper(word1,word2,dp,i,j-1)));
        }
    }
}