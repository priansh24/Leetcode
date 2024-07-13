class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,new ArrayList<>(),ans, new boolean[nums.length]);
        return ans;
    }

    void helper(int[] nums, List<Integer> list,List<List<Integer>> ans,boolean[] used)
    {
        if(list.size()==nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
            for(int i =0;i<nums.length;i++)
            {
                if(used[i]==true || (i>0 && nums[i]==nums[i-1] && used[i-1]==true)) continue;
                used[i] = true;
                list.add(nums[i]);
                helper(nums,list,ans,used);
                used[i] = false;
                list.remove(list.size()-1);            
            }
        
    }
}