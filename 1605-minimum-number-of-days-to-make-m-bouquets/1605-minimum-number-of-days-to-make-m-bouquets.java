class Solution {

    private int minLimit(int[] bloomDay)
    {
        int min = bloomDay[0];
        for(int day:bloomDay)
        {
            // min = Math.min(min,day);
            min = min<day?min:day;
        }
           return min;
    }
    private int maxLimit(int[] bloomDay)
    {
        int max = bloomDay[0];
        for(int day:bloomDay)
        {
            // max = Math.max(max,day);
            max = max>day?max:day;
        }
        return max;
    }
    private boolean isPossible(int[] bloomDay, int day, int m, int k)
    {
        int count = 0, noOfBoq = 0;
        for(int i:bloomDay)
        {
            if(i<=day) count++;
            else
            {
                noOfBoq += count/k;
                count = 0;
            }
        }
        noOfBoq += count/k;
        if(noOfBoq>=m) return true;
        else return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int low = minLimit(bloomDay);
        int high = maxLimit(bloomDay);
        int ans = -1;
        int mid;
        while(low<=high)
        {
            mid = low+(high-low)/2;
            if(isPossible(bloomDay,mid,m,k))
            {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }
}