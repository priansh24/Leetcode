class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums1)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for(int i:nums2)
        {
            if(map.containsKey(i))
            {
                ans.add(i);
                map.remove(i);
            }
        }
        int[] res = new int[ans.size()];
        int index = 0;
        for(int i: ans) res[index++] = i;
        return res;
    }
}