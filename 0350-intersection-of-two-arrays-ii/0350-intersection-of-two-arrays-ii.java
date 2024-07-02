class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1>n2?n2:n1;
        List<Integer> ans = new ArrayList<>();
        if(n1>=n2) helper(nums1,nums2,ans);
        else helper(nums2,nums1,ans);
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