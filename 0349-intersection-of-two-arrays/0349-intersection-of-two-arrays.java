class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums1) set.add(i);
        
        for(int i:nums2)
        {
            if(set.contains(i))
            {
                ans.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[ans.size()];
        int index = 0;
        for(int i: ans) res[index++] = i;
        return res;
    }
}