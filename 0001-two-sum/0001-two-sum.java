class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,j,n = nums.length,sum=0;
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(i = 0;i<n;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                res[0]=i;
                res[1]=map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return res;
    }
}