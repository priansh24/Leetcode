class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        int flag = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                product *= 1;
                flag++;
            }
            else product*=nums[i];
        }
        
        if(flag>1) return ans;
        
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0) ans[i] = product/1;
            else if(flag==1) ans[i] = 0;
            else ans[i] = product/nums[i];
        }
        return ans;
    }
}