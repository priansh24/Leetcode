class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i:nums)
        {
            int n = ans.size();
            for(int j = 0;j<n;j++)
            {
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(i);
                ans.add(list);
            }
        }
        return ans;
    }
}