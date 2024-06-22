class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // int n = nums.length;
        // for(int i=0;i<n;i++)
        // {
        //     if(nums[i]%2==0) nums[i] = 0;
        //     else nums[i] = 1;
        //     System.out.print(nums[i]+" ");
        // }
        // // for(int i=0;i<nums.length;i++)
        // // {
        // //     nums[i] = sum+nums[i];
        // //     sum = nums[i];
        // // }
        // // sum = 0;
        // int sum = 0;
        // int ans = 0;
        // int i=0,j = 0;
        // while(j<n)
        // {       
        //     sum+=nums[j];       
        //     while(sum>k)
        //     {
        //         sum -= nums[i];
        //         i++;
        //     }  
        //     ans += j-i+1;
        //     j++;
        // }
        
        // System.out.println("\nANS: "+ans);
        // return ans;
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;

    }
}