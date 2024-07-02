class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(0,candidates,target,res,new ArrayList<>());
        return res;
    }

    private void helper(int index,int[] candidates, int target, List<List<Integer>> res, List<Integer> list)
    {
        if(target<0) return;
        if(target==0)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index;i<candidates.length;i++)
        {
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i]>target) break;
            list.add(candidates[i]);
            helper(i+1,candidates,target-candidates[i],res,list);
            list.remove(list.size()-1);
        }
    }
}