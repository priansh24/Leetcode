class Solution {
    private int lowerBound(List<Integer> nums, int target)
    {
        int low = 0;
        int high = nums.size()-1;
        int ans=0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums.get(mid)>=target)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        List<Integer> list= new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1;i<nums.length;i++)
        {
            if(nums[i]>list.get(list.size()-1)) list.add(nums[i]);
            else
            {
                int index = lowerBound(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        return list.size();
    }
}