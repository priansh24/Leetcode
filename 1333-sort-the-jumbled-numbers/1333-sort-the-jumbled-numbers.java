class Solution {
    class Pair{
        int val, index;
        Pair(int value, int ind)
        {
            val = value;
            index = ind;
        }
    }

    private int replace(int[] mapping, int num)
    {
        if(num==0) return mapping[0];
        int sum = 0;
        int i = 1;
        while(num>0)
        {
            int dig = num%10;
            sum+=mapping[dig]*i;
            i *= 10;
            num /=10;
        }
        return sum;
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Pair[] arr = new Pair[nums.length];
        for(int i = 0;i<nums.length;i++)
        {
            arr[i] = new Pair(replace(mapping,nums[i]),i);
        }
        Arrays.sort(arr,(a,b)->a.val-b.val);
        int ind = 0;
        int res[] = new int[nums.length];
        for(Pair p:arr)
        {
            res[ind++] = nums[p.index];
        }
        return res;
    }
}