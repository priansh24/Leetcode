class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            // Compare values according to columns
            public int compare(final int[] entry1,final int[] entry2)
            {
                if(entry1[0] == entry2[0])
                {
                    if(entry1[1]>entry2[1]) return -1;
                    else return 1;
                }
                else if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        }); // End of function call sort().
        int ind=0;
        int nums[] = new int[envelopes.length];
        for(int[] i:envelopes)
            nums[ind++] = i[1];
        
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1;i<nums.length;i++)
        {
            if(nums[i]>list.get(list.size()-1)) list.add(nums[i]);
            else
            {
                int index = lowerBound(list,nums[i]);
                list.set(index,nums[i]);
            }
        }
        return list.size();
    }
    private int lowerBound(List<Integer> nums, int target)
    {
        int low = 0;
        int high = nums.size()-1;
        int ans=0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(nums.get(mid)>=target)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
}