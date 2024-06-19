class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: arr1)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int[] ans = new int[arr1.length];
        int ansIndex = 0;
        for(int num:arr2)
        {
            int k = map.get(num);
            while(k>0)
            {
                ans[ansIndex++] = num;
                k--;
            }
            map.remove(num);
        }

        int[] remaining = new int[arr1.length-ansIndex];
        int remainIndex = 0;
        for(int num:arr1)
        {
            int k = map.getOrDefault(num,0);
            while(k>0)
            {
                remaining[remainIndex++] = num;
                k--;
            }
            map.remove(num);
        }
        Arrays.sort(remaining);
        for(int num:remaining)
        {
            ans[ansIndex++] = num;
        }
        return ans;
    }
}