class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> ascending = new ArrayDeque<>();
        ArrayDeque<Integer> descending = new ArrayDeque<>();
        int ans = 0;
        int left = 0;
        int n = nums.length;
        for(int right = 0;right<n;right++)
        {
            while(ascending.isEmpty()==false && ascending.getLast()>nums[right]) ascending.removeLast();
            while(descending.isEmpty()==false && descending.getLast()<nums[right]) descending.removeLast();
            ascending.addLast(nums[right]);
            descending.addLast(nums[right]);
            while(descending.getFirst()-ascending.getFirst()>limit)
            {
                if(descending.getFirst()==nums[left]) descending.removeFirst();
                if(ascending.getFirst()==nums[left]) ascending.removeFirst();
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;

    }
}