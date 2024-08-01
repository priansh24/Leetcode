class Solution {
    int x,y,z;
    public boolean isInterleave(String s1, String s2, String s3) {
        x = s1.length();
        y = s2.length();
        z = s3.length();

        if(x+y!=z) return false;

        Boolean[][] dp = new Boolean[x+1][y+1];
        return helper(0,0,s1,s2,s3,dp);
    }

    private boolean helper(int i, int j, String s1, String s2, String s3, Boolean[][] dp)
    {
        if(i==x && j==y && i+j==z) return true;
        if(i+j>=z) return false;

        if(dp[i][j]!=null) return dp[i][j];

        boolean res = false;

        if(i<x && s1.charAt(i)==s3.charAt(i+j)) res = helper(i+1,j,s1,s2,s3,dp);
        if(res==true) return dp[i][j] = res;
        
        if(j<y && s2.charAt(j)==s3.charAt(i+j)) res = helper(i,j+1,s1,s2,s3,dp);
        return dp[i][j] = res;
    }
}