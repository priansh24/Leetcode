class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = 0;
        for(int i = 1;i<arrays.size();i++)
        {
            List<Integer> list = arrays.get(i);
            int n = list.size();
            ans = Math.max(ans,list.get(n-1)-min);
            ans = Math.max(ans,max - list.get(0));
            min = Math.min(min,list.get(0));
            max = Math.max(max,list.get(n-1));
        }
        return ans;
    }
}