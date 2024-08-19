class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i = 1;i<n;i++)
        {
            int min = Math.min(factor2,Math.min(factor3,factor5));
            ugly[i] = min;
            if(factor2==min)
            {
                index2++;
                factor2 = 2*ugly[index2];
            }
            if(factor3==min)
            {
                index3++;
                factor3 = 3*ugly[index3];
            }
            if(factor5==min)
            {
                index5++;
                factor5 = 5*ugly[index5];
            }
        }
        return ugly[n-1];
   }
}