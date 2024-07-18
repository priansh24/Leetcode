class Solution {
    class Pair
    {
        int val,index;
        Pair(int val, int index)
        {
            this.val = val;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] arr) {
        List<Integer> ans  = new ArrayList<>();
        int n = arr.length;
        Pair[] nums = new Pair[n];
        int[] res = new int[n];
        for(int i=0;i<n;i++)
        {
            nums[i] = new Pair(arr[i],i);
        }
        mergeSort(res,nums,0,n-1);
        for(int i:res)
        {
            ans.add(i);
            // System.out.print(i+" ");
        }
        return ans;
    }

    private void mergeSort(int[] res, Pair[] nums, int left, int right)
    {
        if(left<right)
        {
            int mid = left+(right-left)/2;
            mergeSort(res,nums,left,mid);
            mergeSort(res,nums,mid+1,right);
            merge(res,nums,left,mid,right);
        }
    }

    private void merge(int[] res, Pair[] nums, int left, int mid, int right)
    {
        Pair temp[] = new Pair[right-left+1];
        int i = left;
        int j = mid+1;
        int ind = 0;
        while(i<=mid && j<=right)
        {
            if(nums[i].val<=nums[j].val)
            {
                temp[ind++] = nums[j++];
            }
            else
            {
                res[nums[i].index] += right-j+1; 
                temp[ind++] = nums[i++];
            }
        }

        while(i<=mid) temp[ind++] = nums[i++];
        while(j<=right) temp[ind++] = nums[j++];

        for(i=left;i<=right;i++) nums[i] = temp[i-left];
    }
}