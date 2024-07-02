class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // return helper(candidates,target,0);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }

    void helper(int[] nums, int target, List<List<Integer>> ans, List<Integer> list, int start)
    {
        if(target<0) return;
        if(target == 0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i<nums.length;i++)
        {
            list.add(nums[i]);
            helper(nums, target-nums[i],ans,list,i);
            list.remove(list.size()-1);
        }
        return;
    }
}
    // List<List<Integer>> helper(int[] up, int target,int index)
    // {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if(target==0)
    //     {
    //         ans.add(new ArrayList<>());
    //         return ans;
    //     }
    //     if(target<0) return null;
    //     for(int i = index;i<up.length;i++)
    //     {
    //         int current = up[i];
    //         List<List<Integer>> res = helper(up,target-current,i);
    //         if(res!=null)
    //         {
    //             for(List<Integer> list : res)
    //             {
    //                 list.add(current);
    //                 ans.add(list);
    //             }
    //         }
    //     }
    //     return ans;
    // }
// }