class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        // int[] nums = new int[2*n];
        // int ind = 0;
        // for(int i:arr) nums[ind++] = i;
        // for(int i:arr) nums[ind++] = i;

        int totalOnes = 0;
        for(int i:arr) if(i==1) totalOnes++;

        int swap = 0;
        for(int start = 0;start<totalOnes;start++) if(arr[start]==0) swap++;
        
        int ans = swap;
        int start = 0;
        for(int end = totalOnes;end<2*n;start++,end++)
        {
            if(arr[start%n]==0) swap--; // arr[start%n] is same as nums[start]
            if(arr[end%n]==0) swap++;   // arr[end%n] is same as nums[end]
            ans = Math.min(ans,swap);
        }
        return ans;
    }
}