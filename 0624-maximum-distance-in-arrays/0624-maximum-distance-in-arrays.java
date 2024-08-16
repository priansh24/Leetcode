class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = 0;
        for(int i = 1;i<arrays.size();i++)
        {
            int n = arrays.get(i).size();
            ans = Math.max(ans,arrays.get(i).get(n-1)-min);
            ans = Math.max(ans,max - arrays.get(i).get(0));
            min = Math.min(min,arrays.get(i).get(0));
            max = Math.max(max,arrays.get(i).get(n-1));
        }
        return ans;
    }
}