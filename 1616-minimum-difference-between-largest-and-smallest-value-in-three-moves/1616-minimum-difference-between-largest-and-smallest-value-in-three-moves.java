class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n<=4) return 0;
        Arrays.sort(nums);
        int k = n-1;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<=3;i++)
        {
            ans = Math.min(ans,nums[k+i-3]-nums[i]);
        }
        return ans;
    }
}