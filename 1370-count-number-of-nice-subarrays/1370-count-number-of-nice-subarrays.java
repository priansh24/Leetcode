class Solution {
    private int helper(int nums[],int k)
    {
        int n = nums.length;
        int ans=0;
        for(int num:nums)
        {
            if(k<0) return 0;
            ans = 0;
            int sum = 0;
            int i=0,j = 0;
            while(j<n)
            {       
                sum+=nums[j]%2;       
                while(sum>k)
                {
                    sum -= nums[i]%2;
                    i++;
                }  
                ans += j-i+1;
                j++;
            }
        }
            return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        int[] map = new int[n+1];
        map[0]=1;
        int count = 0;
        for(int i = 0;i<n;i++)
        {
            if(nums[i]%2==1) count++;
            int diff  = count-k;
            if(diff>=0)
            {
                ans += map[diff];
            }
            map[count]++;
        }    
        // int ans = helper(nums,k)-helper(nums,k-1);
        // System.out.println("\nANS: "+ans);
        return ans;
    }
}