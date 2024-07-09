class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        helper(nums1,nums2,ans);
        int[] res = new int[ans.size()];
        int index = 0;
        for(int i: ans) res[index++] = i;
        return res;
    }

    private void helper(int[] a, int[] b, List<Integer> ans)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:b)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for(int i:a)
        {
            if(map.containsKey(i))
            {
                if(map.get(i)>0)
                {
                    map.put(i,map.get(i)-1);
                    ans.add(i);
                }
            }
        }
    }
}