class Solution {
    public int climbStairs(int n) {
        if(n==0||n==1) return 1;
        int previous = 1;
        int current = 1;
        for(int i = 2;i<=n;i++)
        {
            int temp = current;
            current+=previous;
            previous = temp;
        }
        return current;
    }
}