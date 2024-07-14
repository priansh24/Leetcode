class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        System.out.println(n);
        int max = Integer.MIN_VALUE;
        int i = 0,j=n-1;
        while(i<=j)
        {
            int area = (j-i)*Math.min(height[i],height[j]);
            max = Math.max(max,area);
            if(height[i]>=height[j]) j--;
            else i++;
        }
        return max;
    }
}